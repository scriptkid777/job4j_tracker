package ru.job4j.tracker;

public class Reduce {
        private int[] array;

        public void to(int[] array) {
           this.array = array; // ошибка произошла поскольку отсутствовало ключевое слово this которое присваевает параметр метода обьекту
        }

        public void print() {
            for (int index = 0; index < array.length; index++) {
                System.out.println(array[index]);
            }
        }

        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            Reduce reduce = new Reduce();
            reduce.to(array);
            reduce.print();
        }
    }
