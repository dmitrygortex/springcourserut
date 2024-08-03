package org.example.services;

import org.example.entities.Staff;

public interface StaffService {

    // у меня неправильно сделано удаление сотрудников
    // ведь надо как то учесть что сотрудник может быть
    // удалён и тогда его бронирования удалятся,
    // значит нельзя удалять сотрудников
    // а можно только сделать поле для сотрудника по типу fired (уволен)
    // со значениями true или false.
    


    // у меня не правильно сделана сущность STAFF
    // надо было в экспириенс год начала опыта ставить
    // тк иначе каждый год надо обновлять всех сотрудников,
    // не правильно

    void addStaff(Staff staff);

    void removeStaff(Integer staffId);

    Staff getStaffById(Integer staffId);

    void updateStaff(Staff staff);

    Iterable<Staff> getAllStaff();

    Staff findStaffByPricePerHourRange(int minPrice, int maxPrice);
}
