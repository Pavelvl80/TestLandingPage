﻿## ключевых решения
Использованы maven, spring, hibernate.
1. Решено хранить в базе данных только id и xml, без преобразования в специальный класс.

2. Для валидации входящий запросов - JAXB. Таким образом xml документ не соответсвующий схеме
указанной в xmlSchema.xsd будет проигнорирован.

3. Для парсинга входящего xml использован VTD-XML.

4. Указать путь к XML входящего сообщения, по которому определяется тип операции,
               нужно в PathToTriggerElement по стандарту XPath.

5. Любой xml, прошедший валидацию будет сохранен


## Порядок запуска

1. Собрать проет с помощью Maven
2. Настроить сервер (томкат, в моем случае)
3. Указать параметры поключения к базе данных в hibernate.properties
4. использовать SQL-скрипты для создания структуры БД. (sqlScripts.sql)
5. Запустить компилятор

## Достпуные операции
1. Достать xml из базы по параметру id.
    Укажите id в эелемене обозначенным в PathToTriggerElement
