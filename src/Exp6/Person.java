package Exp6;

class Person {
    private String age;
    private String name;

    public Person(String age, String name) {
        this.age = age;
        this.name = name;

    }

    @Override
    public String toString() {
        return "[" +
                  age + '\'' +
                ','+
                 name + '\'' +
                ']';
    }

    public int hashCode() {
        return name.hashCode();// 返回id属性的哈希值
    }


    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Person person = (Person) o;
    //     return name.equals(person.name);
    // }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    public static void main(String[] args) {
        //创建5个随机数
        int[] a = new int[5];
        
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        //冒泡排序
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
