package org.example;

import org.example.config.ApplicationConfig;
import org.example.config.DataSource;
import org.example.dao.PrototypeTest;
import org.example.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  DAO - сервисный слой.
 *  Объекты доступа к данным.
 *  Данный слой отвеяает за доступ к базам данных и другим внешним ресурсам.
 *  Прописаны только методы отвечающие за работу с данными - сохранение, получение, обновление.
 *  Нет бизнес логики
 *  ----------------------------
 *  DTO - Data Transfer Object
 *  ( объект передачи данными )
 *  Это некие POJO, но относятся к кнкретным данным и слою DAO
 *  (Plain old java Object - это те классы, которые созданы для пердачи данных и только для этого.
 *  У них есть только поля Getters, Setters, Constructors)
 *  ----------------------------
 *  Service - классы сервисы, это прослойка между Controllers и DAO.
 *  Тут присутствует вся бизнес логика и обработка данных
 *  ----------------------------
 *  Controller - контроллеры, тобишь классы, которые отвечают за работу с Запросами к серверу.
 *  ----------------------------
 *  IoC, Inversion of Control - инверсия зависимостей.
 *  Она позволяет не беспокоится о том, где нам брать зависимость и данные
 *  -----------------------------
 *  Dependency Injection - Контейнеры Spring IoC
 *  IoC это технология, некое решение, а DI - это её резализация
 *  Один из контейнеров называется ApplicationContext. Это хранилище бинов ( это объекты)
 *  Из которого можно по его имени получить нужный и применить. При необходимости создать его копию.
 *  -----------------------------
 *  Bean - это экземпляр класса, он же объект под управлением Spring Context, он же контейнер
 *  По сути это любой объект, который был создан через new и отправлен в Spring.
 *  Пока Spring управлякт объектом - это Bean, как только он не под управлением, обычный объект
 *  По умолчанию, все бины, которые создаёт Spring, являются singleton бинами.
 *  Это значит, что сколько бы раз мы их не запрашивали.
 *  Вернётся ссылка на один и тот-же объект
 *  ---------------------
 *  Если сделать скоуп prototype , то каждый раз возвращается новый объект
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);
        userDao.findById(3);
        userDao.findAll();

        UserDao userDao1 = applicationContext.getBean(UserDao.class);

        PrototypeTest prototypeTest = applicationContext.getBean(PrototypeTest.class);
        PrototypeTest prototypeTest2 = applicationContext.getBean(PrototypeTest.class);
        PrototypeTest prototypeTest3 = applicationContext.getBean(PrototypeTest.class);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
    }

}
