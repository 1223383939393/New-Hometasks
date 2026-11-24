
**Стек (Stack)** — это структура данных, работающая по принципу **LIFO** (*Last In, First Out* — «последним пришёл, первым вышел»).

Представь стопку тарелок:
* Кладёшь тарелку сверху — `push`.
* Берёшь тарелку сверху — `pop`.
* Посмотреть верхнюю, не снимая — `peek`.
* Нельзя взять нижнюю, не сняв верхние.

Именно так работает стек.

## Зачем нужен стек?

Стек применяется в задачах, где важно обрабатывать данные в обратном порядке или отслеживать историю состояний:
* **Отмена и повтор действий (Undo / Redo)** в текстовых и графических редакторах.
* **Навигация «Назад»** в браузерах и мобильных приложениях.
* **Проверка синтаксиса** (например, парности и правильной вложенности скобок в коде или математических выражениях).
* **Стек вызовов (Call Stack)** в виртуальной машине Java для отслеживания работы методов.

В Java есть два способа реализации со стеком:

| Способ | Класс | Когда использовать |
| :--- | :--- | :--- |
| Классический | `java.util.Stack` | Устаревший, но простой и удобен для изучения |
| Современный | `java.util.ArrayDeque` | Рекомендуется для реальных проектов и быстрой работы |

---

## 1. Класс Stack — классический

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
Stack<String> names = new Stack<>();
```

### Основные методы

| Метод | Что делает | Пример |
| :--- | :--- | :--- |
| `push(item)` | Добавляет элемент на вершину стека | `stack.push(10);` |
| `pop()` | Удаляет и возвращает верхний элемент стека | `int top = stack.pop();` |
| `peek()` | Возвращает верхний элемент, не удаляя его | `int top = stack.peek();` |
| `isEmpty()` | Проверяет, пуст ли стек (`true` или `false`) | `boolean empty = stack.isEmpty();` |
| `size()` | Возвращает количество элементов в стеке | `int count = stack.size();` |

### Пример

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("Анна");
        names.push("Борис");
        names.push("Виктор");

        System.out.println("Верхний элемент: " + names.peek()); // Виктор
        System.out.println("Извлекли: " + names.pop());         // Виктор
        System.out.println("Теперь наверху: " + names.peek());  // Борис
    }
}
```

---

## 2. ArrayDeque — современный стек

`ArrayDeque` — двусторонняя очередь, но её можно использовать как стек.

```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>();
```

### Основные методы

| Метод | Что делает | Пример |
| :--- | :--- | :--- |
| `push(item)` | Добавляет элемент на вершину стека | `stack.push(10);` |
| `pop()` | Удаляет и возвращает верхний элемент стека | `int top = stack.pop();` |
| `peek()` | Возвращает верхний элемент без удаления (или `null`, если стек пуст) | `Integer top = stack.peek();` |
| `isEmpty()` | Проверяет, пуст ли стек (`true` или `false`) | `boolean empty = stack.isEmpty();` |
| `clear()` | Полностью очищает стек от всех элементов | `stack.clear();` |

### Пример

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);

        System.out.println("Верхний элемент: " + stack.peek()); // 300
        System.out.println("Извлекли: " + stack.pop());         // 300
        System.out.println("Пуст ли стек: " + stack.isEmpty()); // false
    }
}
```

---

## Stack vs ArrayDeque: что выбрать

| Свойство | Stack | ArrayDeque |
| :--- | :--- | :--- |
| **Скорость** | Медленнее (методы синхронизированы для многопоточности, что создаёт лишнюю нагрузку) | Быстрее (работает на базе динамического массива без синхронизации) |
| **Значение null** | Разрешает добавление `null` в стек | Запрещает `null` (выбрасывает `NullPointerException`) |

![[Pasted image 20261112125754.png]]