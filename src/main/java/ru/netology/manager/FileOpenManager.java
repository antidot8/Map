package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileOpenManager {
    Map<String, String> fileOpens = new HashMap<>();

    //регистрирует новое приложение с определенным расширением
    public void add(String fileExtension, String appName) {
        fileOpens.put(fileExtension.toLowerCase(), appName.toLowerCase());
    }

    //удаляет привязку приложения, стирает ключ
    public void remove(String fileExtension) {
        fileOpens.remove(fileExtension.toLowerCase());
    }

    //получает название приложения по ключу
    public String getAppName(String fileExtension) {
        return fileOpens.get(fileExtension.toLowerCase());
    }

    //получает список всех расширений с которыми связаны приложения
    public List<String> findAllExtension() {
        Set<String> tmp = fileOpens.keySet();
        ArrayList<String> list = new ArrayList<>(tmp);
        list.sort(String::compareTo);
        return list;
    }

    //получает список всех приложений с которыми связаны расширения
    public Set<String> findAllApp() {
        Collection<String> tmp = fileOpens.values();
        return new HashSet<>(tmp);
    }

    //удаляет привязку приложения, стирает ключ
    public void removeAll() {
        fileOpens.clear();
    }
}