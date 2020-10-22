window.addEventListener("load", function () {
    console.log(JSON.parse(localStorage.getItem('customer')));
    if (JSON.parse(localStorage.getItem('customer'))) {
        customerLog();
    } else {
        clear();
    }
    let d = document,
        itemBox = d.querySelectorAll('.item_box');// блок каждого товара
    cartCont = d.getElementById('cart_content'); // блок вывода данных корзины

// Функция кроссбраузерной установка обработчика событий
    function addEvent(elem, type, handler) {
        if (elem) {
            if (elem.addEventListener) {
                elem.addEventListener(type, handler, false);
            } else {
                elem.attachEvent('on' + type, function () {
                    handler.call(elem);
                });
            }
        }
        return false;
    }

// Получаем данные из LocalStorage
    function getCartData() {
        return JSON.parse(localStorage.getItem('cart'));
    }

// Записываем данные в LocalStorage
    function setCartData(o) {
        localStorage.setItem('cart', JSON.stringify(o));
        return false;
    }

// Получаем данные из LocalStorage
    function getNumber() {
        return JSON.parse(localStorage.getItem('number'));
    }

// Записываем данные в LocalStorage
    function setNumber(o) {
        localStorage.setItem('number', JSON.stringify(o));
        return false;
    }
// Добавляем товар в корзину
    function addToCart(e) {
        this.disabled = true;// блокируем кнопку на время операции с корзиной
        let cartData = getCartData() || [], // получаем данные корзины или создаём новый объект, если данных еще нет
            parentBox = this.parentNode, // родительский элемент кнопки "Добавить в корзину"
            itemId = this.getAttribute('data-id'), // ID товара
            itemTitle = parentBox.parentNode.querySelector('.title').getElementsByTagName('h1')[0].innerHTML, // название товара
            itemPrice = parentBox.querySelector('.price').innerHTML.slice(0, -1), // стоимость товара
            itemGroup = parentBox.parentNode.parentNode.parentNode.getAttribute('data-group');
        console.log(itemId + " " + itemTitle + " " + itemPrice + " " + itemGroup);
        let number = getNumber() || [];
        if (cartData.hasOwnProperty(itemId) && cartData[itemId] !== null) { // если такой товар уже в корзине, то добавляем +1 к его количеству
            number[itemId] += 1;
        } else { // если товара в корзине еще нет, то добавляем в объект
            cartData[itemId] = {
                id: itemId,
                name: itemTitle,
                price: itemPrice,
                group: {id: itemGroup}
            };
            number[itemId] = 1;
        }
        if (!setCartData(cartData) && !setNumber(number)) {// Обновляем данные в LocalStorage
            this.disabled = false; // разблокируем кнопку после обновления LS
        }
        console.log(cartData);
        console.log(number);
        return false;
    }

    // Открываем корзину со списком добавленных товаров
    function openCart(e) {
        let cartData = getCartData(), numbers = getNumber(), // вытаскиваем все данные корзины
            totalItems = '';
        console.log(cartData);
        let totalPrice = 0;
        let id;
        // если что-то в корзине уже есть, начинаем формировать данные для вывода
        if (cartData !== null) {
            totalItems = '<div class="row" style="background: #1959d1"><h1 class="centerh" style="color: white">Корзина:</h1></div>';
            totalItems += '<table class="centerh" style="text-align: center;">';
            for (let i = 1; i < cartData.length; i++) {
                if (cartData[i] !== null) {
                    id = cartData[i]['id'];
                    totalItems += '<tr id="' + id + '">';
                    let group = '';
                    switch (cartData[i]['group']['id']) {
                        case "1": {
                            group = 'ПИЦЦА';
                            break;
                        }
                        case "2": {
                            group = 'СОУС';
                            break;
                        }
                        case "3": {
                            group = 'СНЕК';
                            break;
                        }
                        case "4": {
                            group = 'НАПИТОК';
                            break;
                        }
                    }

                    totalItems += '<td>' + group + '</td>' +
                        '<td><h1>' + cartData[i]['name'] + ' </h1></td>' + '<td></td>' +
                        '<td>' + cartData[i]['price'] + '₽' + '</td>' +
                        '<td>' + '<button id="' + id + '" style="border-radius: 50%;text-align: center;background: #1959d1;color: white" class="minus">-</button></td>' +
                        '<td>' + numbers[cartData[i]['id']] + '</td>' + '<td>' +
                        '<button class="plus" id="' + id + '" style="border-radius: 50%;text-align: center;background: #1959d1;color: white">+</button>'
                        + '<button id="' + id + '" class="x" style="border-radius: 50%;text-align: center;background: #1959d1;color: white">X</button>' +
                        '</td>';

                    totalItems += '</tr>';
                    totalPrice += cartData[i]['price'] * numbers[cartData[i]['id']];
                }
            }
            totalItems += '<tr><h1>Итого:' + totalPrice + '</h1></tr> ' + '</table>';
            cartCont.innerHTML = totalItems;
            let deleteItem = d.querySelectorAll('.x'),
                plusItem = d.querySelectorAll('.plus'),
                minusItem = d.querySelectorAll('.minus');
            for (let i = 0; i < deleteItem.length; i++) {
                addEvent(deleteItem[i], 'click', function (e) {
                    let numbers = getNumber(), cart = getCartData();
                    console.log(e.target.id);
                    let id = e.target.id;
                    numbers[id] = null;
                    cart[id] = null;
                    setNumber(numbers);
                    setCartData(cart);
                    document.getElementById(id).outerHTML = '';
                    console.log(numbers);
                    console.log(cart);

                });
                addEvent(minusItem[i], 'click', function (e) {
                    let id = e.target.id;
                    let numbers = getNumber();
                    if (numbers[id] > 1) {
                        console.log(e.target.id);

                        numbers[id] -= 1;
                        setNumber(numbers);

                        document.getElementById(id).getElementsByTagName("td")[5].innerHTML = numbers[id];
                        console.log(numbers);
                    }


                })
                addEvent(plusItem[i], 'click', function (e) {
                    let id = e.target.id;
                    let numbers = getNumber(), cart = getCartData(),
                        group = cart[id]['group']['id'];
                    if (numbers[id] < checkMaxItem(group)) {
                        console.log(e.target.id);
                        numbers[id] += 1;
                        setNumber(numbers);
                        document.getElementById(id).getElementsByTagName("td")[5].innerHTML = numbers[id];
                        console.log(numbers);
                    }
                })
            }


        } else {
            // если в корзине пусто, то сигнализируем об этом
            let div = document.createElement("div");
            let h1 = document.createElement("h1");
            div.class = "row";
            div.style = "background: #1959d1";
            h1.style = "margin-left: 30%; color: white";
            h1.innerHTML = 'В корзине пусто!';
            div.appendChild(h1);
            cartCont.appendChild(div);
        }
        return false;
    }

// Устанавливаем обработчик события на каждую кнопку "Добавить в корзину"
    for (var i = 0; i < itemBox.length; i++) {
        addEvent(itemBox[i].querySelector('.add'), 'click', addToCart);
    }

    //exit customer
    addEvent(d.getElementById('clear_customer'), 'click', clear);
    /* Открыть корзину */
    addEvent(d.getElementById('checkout'), 'click', openCart());
    /* Очистить корзину */
    addEvent(d.getElementById('clear_cart'), 'click', function (e) {
        localStorage.removeItem('cart');
        localStorage.removeItem('number');
        alert("\u041a\u043e\u0440\u0437\u0438\u043d\u0430\u0020\u043e\u0447\u0438\u0449\u0435\u043d\u0430\u002e");
        window.location.reload();
    });

    //начать оформлять заказ
    addEvent(d.getElementById('order'), 'click', function (e) {

        let form = '<div style="height: 50px"></div> <div style="margin-left: 30%"><h1> Телефон: 8<input id="phoneOrder" type="text" size="10"></div><div style="height: 50px"></h1></div>' +
            '<div style="margin-left: 30%" id="del"> ' +
            '<h1 style="margin-left: 30%">Тип Доставки:</h1>' +
            '<h1><input type="radio" name="delivery" id="2">Курьером</h1>' +
            '<h1><input type="radio" name="delivery" id="3">Телепортация</h1><p>Как в "Рик и Морти" да-да</p>' +
            '<h1><input type="radio"  name="delivery" id="1">Самовывоз</h1>' +
            ' <div style="height: 50px"></div></div><div id="point"></div> <div style="height: 50px"></div>' +
            '<input type="button" class="buttonOrder" value="Заказать" onclick="sendOrder()" style="margin-left: 30%">';
        document.getElementById('order_content').innerHTML = form;
        $('#del input[type=radio]').change(function () {
            if ($(this).parent().index() === 4) {
                let point = '<div style="margin-left: 30%" id="pointCheck"> ' +
                    '<h1 style="background: #1959d1; color: white">Выберите адрес, по которому хотите забрать заказ:</h1>';
                let pointData = JSON.parse(localStorage.getItem('point'));
                for (let i = 0; i < pointData.length; i++) {
                    point += '<h1><input type="radio" name="point" id="' + (i + 1) + '">' + pointData[i] + '</h1>';
                }
                document.getElementById("point").innerHTML = point;
            } else {
                document.getElementById("point").innerHTML = '';
            }

        });

    })


})



function checkMaxItem(item) {
    switch (item) {
        case "1": {
            return 5
        }
        case "2": {
            return 20
        }
        case "3": {
            return 10
        }
        case "4": {
            return 5
        }
    }

}



