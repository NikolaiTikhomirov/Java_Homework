public class MainApp {
    public static void main(String[] args) {
        /**
     * Создать класс Сотрудник (Employee).
     * У класса должны быть следующие поля:
     * 1. Возраст (int) 
     * 2. Имя (String)
     * 3. Фамилия (String)
     * 4. Зарплата (double)
     * 5. ... можно придумать свои поля
     *
     * У класса должно быть 2 конструктора:
     * 1. Конструктор, который принимает все аргументы
     * 2. Констуктор, который принимает все аргументы КРОМЕ зарплаты; значение зарплаты должно быть задано значением по умолчанию (50.0)
     *
     * Переопределить:
     * 1. Методы equals и hashCode (поля, которые должны там участвовать, нужно определить самостоятельно)
     * 2. Метод toString (в любом формате)
     *
     * * Реализовать методы:
     * 1. String getFullName() - возвращает полное имя сотрудника
     * 2. boolean olderThan(Employee e) - возвращает true, если текущий сотрудник старше чем тот, который передали в метод.
     * 3. void upgrade(double salary) - повышает зарплату сотрудника НА salary единиц.
     * Пример: Было 50.0, upgrade(20.0) -> стало 70.0
     */
    Employee employee1 = new Employee(30, "Якорь", "Багровский", 99911100);
    Employee employee2 = new Employee(20, "Выпивак", "Закусов", 888777001, 100.0);
    Employee employee3 = new Employee(20, "Бегун", "Полежайкин", 100011122, 100500.0);
    Employee employee4 = new Employee(20, "Бегун", "Полежайкин", 100011122, 1000.0);

    System.out.println(Employee.employeeCounter);
    System.out.println();
    System.out.println(employee1.hashCode());
    System.out.println(employee2.hashCode());
    System.out.println(employee3.hashCode());
    System.out.println(employee4.hashCode());
    System.out.println();
    System.out.println(employee1.toString());
    System.out.println(employee2.toString());
    System.out.println(employee3.toString());
    System.out.println();
    System.out.println(employee1.getFullName());
    System.out.println(employee2.getFullName());
    System.out.println(employee3.getFullName());
    System.out.println();
    System.out.println(employee1.equals(employee4));
    System.out.println(employee3.equals(employee4));
    System.out.println();
    System.out.println(employee1.olderThan(employee2));
    System.out.println(employee3.olderThan(employee1));
    System.out.println();
    System.out.println(employee3.getSalary());
    employee3.upgrade(100200);
    System.out.println(employee3.getSalary());
    }
}
