package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileOpen implements Comparable<FileOpen> {
    private String fileExtension; //Ключ
    private String appName; //Значение

    @Override
    public int compareTo(FileOpen o) {
        return this.fileExtension.compareTo(o.fileExtension);
    }
}