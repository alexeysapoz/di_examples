# DI
Services need to expose information on what dependencies they need.

Instead of creating dependent service implementations inside the service itself, references to dependent services are "injected". 

# Зачем
* удобноее резделять на компоненты
* удобнее тестировать
# Вручную
```scala
class A { ... }
class B(a: A) { ... }

object Application {
  lazy val a: A = new A
  lazy val b: B = new B(a)
}
```
# Вручную/за
* Нет магии
* Всё compile-time
* Нет run-time рефлексии => быстрый старт
* Гибко
* Нет войны с чужими фрэймворками

# Вручную/против
* ВРУЧНУЮ
* Если потерять бдительность, кто-нибудь создать СВОЙ фрэймворк

# Implicit
```scala
class A { ... }
class B(implicit a: A) { ... }

object Application {
  implicit lazy val a: A = new A
  implicit lazy val b: B = new B
}
```
# Spring
https://github.com/alexeysapoz/di_examples/tree/master/1_spring/src/main/scala

# Spring/за
* Разнообразие конфигураций
* Богатая экосистема
* Многие знают

# Spring/против
* run-time рефлексия
* Долгая инициализация
* Многие ошибки обнаруживаются только после старта приложения
* Многие знают хорошо?

# Guice
https://github.com/alexeysapoz/di_examples/tree/master/3_macwire/src/main/scala

# Guice/за
* Не тянет за собой целую экосистему, решает более узкую область задач

# Guice/против
* Всё ещё run-time

# MacWire
https://github.com/alexeysapoz/di_examples/tree/master/3_macwire/src/main/scala

# MacWire/за
* compile-time (можно обойтись даже без run-time зависимостей)

# MacWire/против
* macro магия
* только scala (несущественно для большинства проектов)

