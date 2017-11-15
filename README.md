## ключевые решения
1. Проект построен на фреймворке Spring
2. Для сборки проекта использован Maven
3. Hibernate в качестве реализации jpa
4. В качестве тестового сервера выбран Tomcat
5. База данных - Oracle standart edition two
6. Парсеры JAXB и XPath

## Порядок запуска

1. Собрать проект с помощью Maven
2. подключить сервер
3. Указать параметры подключения к базе данных можно в hibernate.properties (src/main/resources/hibernate.properties)
4. Указать путь к элементу, по которому будет определена операция (стандарт XPath) (src/main/resources/pathToMetaElement.properties) 
5. использовать SQL-скрипты для создания структуры БД. (sql/sqlScripts.sql)
6. Запустить проект

## Условия
1. Входящий запрос должен иметь тип xml (application/xml) без четко определенной
структуры. Элемент, по которому будет выбрана операция, указывается в конфиге.
Входящий xml парситься с помощью XPAth, после чего его значение присваиваются переменным класса XmlRequest. 
В базу данных сохраняется id (присваивается автоматически),
выбранный элемент (MetaElement) и Весь запрос целиком (fullRequest).

2. Ответ напротив имеет четко определенную структуру* и должен быть сохранен в базу 
с помощью sql скрипта. XMl ответ при выборки из базы конвертируется с помощью JAXB в java обьет (XmlResponce),
после - в Stirng в формате xml.

4. Ответ имеет формат Http xml response

5. Выбор элемента из базы осуществляется по значению переменной responseName.

7. Отсылать запрос нужно по ссылке /request <br>
    пример: http://localhost:8080/request

6. Для работы с приложением нужно использовать REST клиент.


*структура для ответного xml:

\<response> <br>
    \<name>name\</name> <br>
    \<message>message\</message> <br>
\<response>

## примеры запроса

значение файла pathToMetaElement.properties:
pathToElement=request/name[1]

Запрос: <br>
\<request> <br>
    \<name>one\</name> <br>
    \<something>test\</something> <br>
\</request> <br>

значение файла pathToMetaElement.properties:
pathToElement=send/this/element[1]

Запрос: <br>
\<send> <br>
    \<this> <br>
        \<element>two\</element> <br>
    \</this> <br>
\</send> <br>
