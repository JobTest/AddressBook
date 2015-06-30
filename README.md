###Условия (настройка) установки/запуска

1. Нужен maven 2.x
2. Spring 3.x
3. Подходит Tomcat 7.X
4. Контекст для деплоя на томкат "AddressBook"


Веб приложения с Регистрация, авторизацией, каталогом сотрудников организации.
==============================================================================

1 `Сотрудник:` Имя, Фамилия, Логин, Пароль, e-mail, Отдел, Телефон, Должность
2 `Отдел:` Название


###Вид и функциональность web приложения

1. Контроль доступа – каждый сотрудник заходит под своим логином . необходимо сделать систему регистрации сотрудника и авторизации.
2. Возможность редактировать свои персональные данные – остальные только просмотр
3. Добавление нового сотрудника;
4. Удаление сотрудника;
5. Редактирование данных;
6. Поиск сотрудников;
7. Валидация данных;


###Инструменты
   
1. Apache Tomcat
2. MySQL
3. Maven
4. Hibernate
5. JPA
6. Spring
7. SQL
8. MVC


###Требования к исполнению:
   
1.    Авторизацию сделать использую Spring Security
2.    Использовать Hibernate
3.    Пароли/пользователи хранить в базе данных (MySQL)
4.    Использовать шифрование AES256 для паролей
5.    Сервер приложений Apache Tomcat
6.    Пакет с решением должен содержать
> a. исходный код программы
> b. структуру и dump данных
> c. скомпилированная и готовая программа
> d. Техническое описание в коде - комментарии



Техническое описание:
=====================

1. Для разработки приложения был использован 'Spring' фреймворк с версией 3.x.
2. Конфигурарию 'Spring'-а постарался вынести а XML, что должно упростить юзабельность модулей приложения.
3. В целом веб-приложение можно разделить на: специальные/служебные веб-страницы ('404', '500', 'login', ...) которые настраиваются в конфигурации XML 'Spring'. И рабочие веб-страницы ('list', 'view', 'edit', 'new', ...) которые обрабатываются с помощью контроллера реализованного с помощью 'Spring'
4. В свою же очередь рабочие веб-страницы придерживаются следующей структуры: 'header', 'content', 'footer'. Из которой контекст каждой рабочей страницы содержит только ожидаемую структуру.
5. Для работы с базой использовал JPA/Hibernate. Разработал структуру из 2-х таблиц: 'users' и 'user_role', которые позволяют поддерживать ролевую политику для доступа к веб-ресурсам.
6. База 'MySQL'. Связь между таблицами 'OneToOne'. Для построения более сложных транзакций в механизме поиска ограничился JPA интерфейсом.
7. На клиентской стороне использую JavaScript фреймворки ('jquery', 'jquery.validate', 'aes'). Шифрование и валидация формы для клиента выполняетчя на стороне клиента - такой подход позволяет передавать на серверную часть приложения данные уже в зашифрованной и в правильной форме (что гарантирует надежность).
8. Поддерживаются сессии для авторизированных пользователей. Поскольку маштаб веб-приложения небольшой, я ограничился JSP веб-страничками. Также включил в архитектуру мульти-языковую поддержку для текста (пример: меню, кнопки, ...).