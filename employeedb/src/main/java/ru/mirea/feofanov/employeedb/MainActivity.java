package ru.mirea.feofanov.employeedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();
        employee.id = 1;
        employee.name = "Superman";
        employee.strength = 10000;
        // запись супер-героев в базу
        employeeDao.insert(employee);
        // Загрузка всех супер-героев
        List<Employee> employees = employeeDao.getAll();
        // Получение определенного супер-героя с id = 1
        employee = employeeDao.getById(1);
        // Обновление полей объекта
        employee.strength = 20000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.strength);
    }
}