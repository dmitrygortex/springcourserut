# Система бронирования студий звукозаписи

## Сущности, входящие в ПО:

- Студия 
- Клиент 
- Бронирование 
- Персонал
- Оборудование
- Услуга
- Бронирование услуги

## Сценарии:

1) Клиент может искать доступные студии по различным параметрам (например, по расположению, типу оборудования или цене) и бронировать студию на определенную дату и время (когда клиент бронирует студию идёт проверка на то какой статус у студии и не забронированная ли она уже)
2) Клиент должен иметь возможность просматривать и управлять своими бронированиями, включая изменение даты и времени, отмену бронирования или добавление дополнительных услуг (и при изменении параметров бронирования меняется стоимость)
3) Система должна обеспечивать безопасный и удобный способ оплаты бронирований.
4) Владельцы студий должны иметь возможность управлять оборудованием и персоналом в системе. Они могут добавлять или удалять оборудование, обновлять его состояние и назначать сотрудников на бронирования.


## NEED TO DO:

- [x] Добавить таблицу услуг "Facility" с атрибутами id, name, description, price
- [x] Добавить таблицу бронирования услуг "BookFacility" с атрибутами id, serviceID, bookingID, quantity
- [x] В Staff изменить поле с опытом работы
- [x] Добавить по все таблицы атрибут is_deleted + изменить модели
- [x] Убрать JPA репозитории и реализовать их правильно
- [ ] Переписать сервисы с учётом изменений выше
- [ ] Написать контроллеры и переделать DTO 


#

#### Голиков Дмитрий Александрович УВП-212
