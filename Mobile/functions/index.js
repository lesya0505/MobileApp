const functions = require('firebase-functions');

const json = [
    {
        "name": "Корвалтаб",
        "components": "Етиловий ефір, Фенобарбітал, Олія м'ятна",
        "category":  "Серцеві препарати",
        "packaging" : "Таблетки",
        "producer": "Асіно",
        "price": "26 грн.",
        "photoUrl": "https://compendium.com.ua/img/dec/x63609_98_38_18_12.jpg.pagespeed.ic.8RR1xYtfgp.webp"
    },
     {
        "name": "Но-шпа",
        "components": "Дротаверин гідрохлорид",
        "category":  "Спазмолітичні засоби",
        "packaging" : "Таблетки",
        "producer": "Chinoin",
        "price": "216 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/n/o/no_spa_40mg__24_02_1/add.ua-chinoin-(vengrija)-no-shpa-40-mg-tabletki-%E2%84%9624-39.jpg"
    },
     {
        "name": "Амізон",
        "components": "Амізон (енісаміум йодид)",
        "category":  "Противірусні препарати",
        "packaging" : "Таблетки",
        "producer": "Фармак ОАО",
        "price": "55 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/2/5/250_3/add.ua-farmak-oao-(ukraina,-kiev)-amizon-0,25-g-tabletki-%E2%84%9610-33.jpeg"
    },
        {
        "name": "Лінекс",
        "components": "Aнтибіотикорезистенті молочнокислі бактерії",
        "category":  "Препарати для кишечника",
        "packaging" : "Капсули",
        "producer": "Sandoz",
        "price": "109 грн.",
        "photoUrl": "https://media.add.ua/media/category_block/add.ua-sandoz-lineks-kapsuly--32-31.jpg"
    },
        {
        "name": "Вентер",
        "components": "Сукральфат,тальк кремнію діоксид колоїдний",
        "category":  "Ліки для шлунка",
        "packaging" : "Таблетки",
        "producer": "KRKA",
        "price": "193",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_10_27/add.ua-krka-(slovenija)-venter-1-g-tabletki-%E2%84%9650-33.jpeg"
    },
        {
        "name": "Ібупрофен",
        "components": "Ібупрофен",
        "category":  "Протизапальні засоби",
        "packaging" : "Таблетки",
        "producer": "Борщагівський ХФЗ",
        "price": "34 грн.",
        "photoUrl": "https://compendium.com.ua/img/dec/x4954_102_47_35_28.jpg.pagespeed.ic.2RX_6YU0vs.webp"
    },
    {
        "name": "Домідон",
        "components": "Домперидон",
        "category":  "Препарати для кишечника",
        "packaging" : "Таблетки",
        "producer": "Фармак ОАО",
        "price": "78 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_155_4/add.ua-farmak-oao-(ukraina,-kiev)-domidon-10-mg-tabletki-%E2%84%9630-32.jpg"
    },
    {
        "name": "Лоратадин",
        "components": "Лоратадин, лактоза, моногідрат;",
        "category":  "Антигістамінні засоби",
        "packaging" : "Таблетки",
        "producer": " Артеріум",
        "price": "12 грн.",
        "photoUrl": "https://compendium.com.ua/img/dec/x45751_100_45_17_8.jpg.pagespeed.ic.W_ZP7gRWON.webp"
    },
    {
        "name": "Німесил",
        "components": "Німесулід",
        "category":  "Протизапальні засоби",
        "packaging" : "Порошок",
        "producer": "Laboratori GUIDOTTI",
        "price": "214 грн.",
        "photoUrl": "https://compendium.com.ua/img/dec/xberlin_chemie_nimesil.jpg.pagespeed.ic.twAb5j433Y.webp"
    },
    {
        "name": "Імодіум",
        "components": "Лоперамід гідрохлорид",
        "category":  " Препарати для кишечника",
        "packaging" : "Капсули",
        "producer": "Янссен Силаг",
        "price": "80 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/2/0/20_57/add.ua-janssen-silag-(francija)-imodium-2-mg-kapsuli-%E2%84%9620-35.jpg"
    },
     {
        "name": "L-ЦЕТ",
        "components": "Левоцетиризин дигідрохлорид",
        "category":  "Ліки від алергії",
        "packaging" : "Таблетки",
        "producer": "Kusum Healthcare",
        "price": "109 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/1/0/102718_2/add.ua-kusum-healthcare-(indija)-l-cet-5-mg-tabletki-%E2%84%9630-30.jpg"
    },
     {
        "name": "Гриппостад",
        "components": "Парацетамол,кислота лимонна,сахароза",
        "category":  "Ліки від застуди та ГРВІ",
        "packaging" : "Порошок",
        "producer": "Stada",
        "price": "96 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/g/r/grippostad-poroshok/add.ua-stada-(nimechchina)-grippostad-gorjachij-napitok-5-g-poroshok-%E2%84%965-31.jpg"
    },
     {
        "name": "Мефенамінка",
        "components": "Мефенамінова кислота",
        "category":  "Ліки від застуди та ГРВІ",
        "packaging" : "Таблетки",
        "producer": "Дарница ЗАО",
        "price": "67 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_58_237/add.ua-darnica-zao-(ukraina,-kiev)-mefenaminova-kislota-0,5-g-tabletki-%E2%84%9620-30.jpg"
    },
     {
        "name": "Нурофен",
        "components": "Ібупрофен,натрій кроскармелоз,лаурилсульфат",
        "category":  "Знеболюючі",
        "packaging" : "Таблетки",
        "producer": "Reckitt Benckiser Healthcare",
        "price": "101 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/_/-/_-200-_-_-_24/add.ua-reckitt-benckiser-healthcare-(uk)-(velika-britanija)-nurofen-200-mg-tabletki-%E2%84%9624-34.jpg"
    },
     {
        "name": "Нафтизин",
        "components": "Нафазолін нітрат",
        "category":  "Ліки від застуди та ГРВІ",
        "packaging" : "Краплі",
        "producer": "Фармак ОАО",
        "price": "20 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_132_124/add.ua-farmak-oao-(ukraina,-kiev)-naftizin-0,05-krapli-10-ml-(sklo)-33.jpg"
    },
     {
        "name": "Спазмалгон",
        "components": "Метамізол натрію,пітофенону гідрохлориду",
        "category":  "Спазмолітичні засоби",
        "packaging" : "",
        "producer": "Balkanpharma-Dupnitza",
        "price": "40 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/_/-/_-_-1_1_20/add.ua-balkanpharma-dupnitza-(bolgarija)-spazmalgon-500-mg-tabletki-%E2%84%9610-31.jpg"
    },
     {
        "name": "Валідол",
        "components": "Розчину ментолу,цукор",
        "category":  "Серцеві препарати",
        "packaging" : "Таблетки",
        "producer": "Фармак ОАО ",
        "price": "7 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/p/r/preparat_bigs_3/add.ua-farmak-oao-(ukraina,-kiev)-validol-0,06-g-tabletki-%E2%84%9610-33.jpg"
    },
     {
        "name": "Корвалол",
        "components": "фенобарбітал,ефір a-бромізовалеріанової кислоти",
        "category":  "Серцеві препарати",
        "packaging" : "Таблетки",
        "producer": "Фармак ОАО",
        "price": "37 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/p/r/preparat_bigs-_1__2_2/add.ua-farmak-oao-(ukraina,-kiev)-korvalol-tabletki-%E2%84%9630-32.jpg"
    },
     {
        "name": "Декатилен",
        "components": "декваліній хлорид, дибукаїн гідрохлорид",
        "category":  "Знеболюючі",
        "packaging" : "Таблетки",
        "producer": "Acino Pharma",
        "price": "201 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/d/e/decatilen_40_left/add.ua-acino-pharma-(nimechchina)-dekatilen-tabletki-dlja-rasmoktuvannja-%E2%84%9640-32.png"
    },
     {
        "name": "Алерон",
        "components": "Левоцетиризин дигідрохлорид",
        "category":  "Антигістамінні засоби",
        "packaging" : "Таблетки",
        "producer": "Actavis Group",
        "price": "125 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/_/-/_-_-1_2_45/add.ua-actavis-group-(islandija)-aleron-5-mg-tabletki-%E2%84%9630-32.jpg"
    },
     {
        "name": "Аспірин",
        "components": "Ацетилсаліцилова кислота",
        "category":  " Знеболюючі",
        "packaging" : "Таблетки",
        "producer": "Bayer Consumer Care",
        "price": "38 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/_/1/_10_8/add.ua-bayer-consumer-care-(shvejcarija)-aspirin-0,5-tabletki-%E2%84%9610-33.jpg"
    },
     {
        "name": "Бепантен",
        "components": "Декспантенол",
        "category":  " Дитячі ліки",
        "packaging" : "Крем",
        "producer": "ГП Грензах Продуктіонс ГмбХ",
        "price": "335 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/1/_/1_137/add.ua-gp-grenzah-produktions-gmbh,-nimechchina-bepanten-5-krem-100-g-32.jpg"
    },
 {
        "name": "Фромілід",
        "components": "Кларитроміцин",
        "category":  "Антибіотики",
        "packaging" : "Таблетки",
        "producer": "KRKA",
        "price": "125 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/2/5/250_1_6/add.ua-krka-(slovenija)-fromilid-250-mg-tabletki-%E2%84%9614-32.jpeg"
    },
 {
        "name": "Лопракс",
        "components": "Цефіксим",
        "category":  "Антибіотики",
        "packaging" : "Таблетки",
        "producer": "Exir Pharmaceutical",
        "price": "248 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_14_7/add.ua-exir-pharmaceutical-(iran)-lopraks-400-mg-tabletki-%E2%84%966-32.jpeg"
    },
 {
        "name": "Фітолізин",
        "components": "Пирій,насіння пажитнику,лушпиння цибулі,олія шавлієва",
        "category":  "Урологічні препарати",
        "packaging" : "Паста",
        "producer": "Herbapol",
        "price": "185 грн.",
        "photoUrl": "https://media.add.ua/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/f/i/fitolizin-100/add.ua-herbapol-(pol-scha,-varshava)-fitolizin-pasta-100-g-31.jpg"
    }
];
exports.pharmacy = functions.https.onRequest((request, response) => {response.send(json);
});
