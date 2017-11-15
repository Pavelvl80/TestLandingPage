﻿## ключевых решения
1. Проеет построет на фреймворке Spring
2. Для сборки проекта использован Maven
3. Hibernate в качестве реализации jpa
4. В качестве тестовго сервера выран Tomcat
5. База данных - Oracle standart edition two
6. Парсеры JAXB и XPath

## Порядок запуска

1. Собрать проект с помощью Maven
2. подключить сервер
3. Указать параметры поключения к базе данных в hibernate.properties (src/main/resources/hibernate.properties)
4. Указать путь элементу, по которому будет определена операция, (стандарт XPath) (src/main/resources/pathToMetaElement.properties) 
5. использовать SQL-скрипты для создания структуры БД. (sql/sqlScripts.sql)
6. Запустить проект

## Условия
1. Входящий запрос должен иметь тип xml (application/xml) без четко определенной
структуры. Елемент, по которуму будет выбрана операция, указывается в конфиге.
Входящий xml парсится с помощью XPAth,. В базу данных сохраняется id (присвается автоматически),
выбранный элемент (MetaElement) и Весь запрос целиком (fullRequest).

2. Ответ напротив имеет четко определенную структуру* и должен быть сохранен в базу 
с помощью sql срипта. XMl ответ при выборки из базы конвертируется с помощью JAXB в java обьет (XmlResponce),
после - в Stirng в формате xml.

4. Ответ имеет формат Http xml response

5. Выбор элемента из базы осуществлаятся по значению переменной responseName.

6. Для работы с приложением нужно использовать REST клиент.

*
<response>
    <id>id</id>
    <name>name</name>
    <message>message</message>
<response>

## примеры запроса

значение файла pathToMetaElement.properties:
pathToElement=request/name[1]

Запрос:
<request>
    <name>one</name>
    <something>test</something>
</request>

значение файла pathToMetaElement.properties:
pathToElement=send/this/element[1]

Запрос:
<send>
    <this>
        <element>two</element>
    </this>
</send>
	
