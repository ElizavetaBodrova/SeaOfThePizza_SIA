window.addEventListener("load", function () {
    /*localStorage.removeItem('cart');
    localStorage.removeItem('number');*/
    console.log(localStorage.getItem('cart'));
    var d = document,
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
        this.disabled = true;
        console.log(this.parentNode.parentNode);// блокируем кнопку на время операции с корзиной
        let cartData = getCartData() || [], // получаем данные корзины или создаём новый объект, если данных еще нет
            parentBox = this.parentNode, // родительский элемент кнопки "Добавить в корзину"
            itemId = this.getAttribute('data-id'), // ID товара
            itemTitle = parentBox.parentNode.querySelector('.title').getElementsByTagName('h1')[0].innerHTML, // название товара
            itemPrice = parentBox.querySelector('.price').innerHTML.slice(0, -1), // стоимость товара
            itemGroup = parentBox.parentNode.parentNode.parentNode.getAttribute('data-group');
        console.log(itemId + " " + itemTitle + " " + itemPrice + " " + itemGroup);
        let number = getNumber() || {};
        if (cartData.hasOwnProperty(itemId) && cartData[itemId]!==null) { // если такой товар уже в корзине, то добавляем +1 к его количеству
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
    // Открываем корзину со списком добавленных товаров
    function openCart(e){
        let cartData = getCartData(), numbers=getNumber(), // вытаскиваем все данные корзины
            totalItems = '';
        console.log(cartData);
        // если что-то в корзине уже есть, начинаем формировать данные для вывода
        if(cartData !== null){
            totalItems = '<table class="shopping_list">';
            for(let i=1;i<cartData.length;i++){
                if(cartData[i]!==null){
                    totalItems += '<tr>';
                    totalItems += '<td>' + cartData[i]['name'] + '</td>'+
                        '<td>' + cartData[i]['price']+ '</td>'+
                        '<td>' + numbers[cartData[i]['id']] + '</td>';

                    totalItems += '</tr>';
                }



            }
            totalItems += '</table>';

            cartCont.innerHTML = totalItems;
        } else {
            // если в корзине пусто, то сигнализируем об этом
            cartCont.innerHTML = 'В корзине пусто!';
        }
        return false;
    }
    /* Открыть корзину */
    addEvent(d.getElementById('checkout'), 'click', openCart);
    /* Очистить корзину */
    addEvent(d.getElementById('clear_cart'), 'click', function(e){
        localStorage.removeItem('cart');
        localStorage.removeItem('number');
        alert("\u041a\u043e\u0440\u0437\u0438\u043d\u0430\u0020\u043e\u0447\u0438\u0449\u0435\u043d\u0430\u002e");
    });
})