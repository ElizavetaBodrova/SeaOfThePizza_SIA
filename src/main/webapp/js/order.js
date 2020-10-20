window.addEventListener("load", function () {
    localStorage.removeItem('cart');
    localStorage.removeItem('number');
    var d = document,
        itemBox = d.querySelectorAll('.item_box');
    console.log(itemBox);// блок каждого товара
    //cartCont = d.getElementById('cart_content'); // блок вывода данных корзины
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
        this.disabled = true;
        console.log(this.parentNode.parentNode);// блокируем кнопку на время операции с корзиной
        let cartData = getCartData() || {}, // получаем данные корзины или создаём новый объект, если данных еще нет
            parentBox = this.parentNode, // родительский элемент кнопки "Добавить в корзину"
            itemId = this.getAttribute('data-id'), // ID товара
            itemTitle = parentBox.parentNode.querySelector('.title').getElementsByTagName('h1')[0].innerHTML, // название товара
            itemPrice = parentBox.querySelector('.price').innerHTML.slice(0, -1), // стоимость товара
            itemGroup = parentBox.parentNode.parentNode.parentNode.getAttribute('data-group');
        console.log(itemId + " " + itemTitle + " " + itemPrice + " " + itemGroup);
        let number = getNumber() || {};
        if (cartData.hasOwnProperty(itemId)) { // если такой товар уже в корзине, то добавляем +1 к его количеству
            number[itemId] += 1;
        } else { // если товара в корзине еще нет, то добавляем в объект
            cartData[itemId] = {
                id: itemId,
                name: itemTitle,
                price: itemPrice,
                id_group: {id: itemGroup}
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


// Устанавливаем обработчик события на каждую кнопку "Добавить в корзину"
    for (var i = 0; i < itemBox.length; i++) {
        addEvent(itemBox[i].querySelector('.add'), 'click', addToCart);
    }
    /*
    // Открываем корзину со списком добавленных товаров
    function openCart(e){
        var cartData = getCartData(), // вытаскиваем все данные корзины
            totalItems = '';
        // если что-то в корзине уже есть, начинаем формировать данные для вывода
        if(cartData !== null){
            totalItems = '<table class="shopping_list"><tr><th>Наименование</th><th>Цена</th><th>Кол-во</th></tr>';
            for(var items in cartData){
                totalItems += '<tr>';
                for(var i = 0; i < cartData[items].length; i++){
                    totalItems += '<td>' + cartData[items][i] + '</td>';
                }
                totalItems += '</tr>';
            }
            totalItems += '</table>';
            cartCont.innerHTML = totalItems;
        } else {
            // если в корзине пусто, то сигнализируем об этом
            cartCont.innerHTML = 'В корзине пусто!';
        }
        return false;
    }
    /!* Открыть корзину *!/
    addEvent(d.getElementById('checkout'), 'click', openCart);
    /!* Очистить корзину *!/
    addEvent(d.getElementById('clear_cart'), 'click', function(e){
        localStorage.removeItem('cart');
        cartCont.innerHTML = 'Корзина очишена.';
    });*/
})