## Что предстоит сделать
- Сделать сортировку задач по различным параметрам
- Добавить возможность создание подзадач
- Добавить возможность ввода дедлайна по нескольким шаблонам
- Подключить базу данных для хранения списка задач
- Реализовать пользователей для базы данных
- Нарисовать графический интерфейс

## Что сделано?
- Реализована команда help
- Реализована команда exit
- Реализовано генерация id для задач
- Реализована команда для добавления задачи add_task
- Реализована команда для вывода списка задач на экран print_tasklist
- Реализована проверка на при превышении лимита по количеству задач
- Реализована валидация на ввод аргументов для задачи delete_task (не буква, не отрицательное число)
- Реализован вывод о том, что список задач пуст, при команде print_tasklist
- Реализовано оповещение о том, что команды должны начинаться со слэша
- Реализована команда для удаления задачи по её ID
- Реализован вывод Enum при вводе приоритета задачи
- Переехали на Gradle
- Реализована команда для редактирования задачи edit_task

## Как добавлять новые команду в программу?
1. Необходимо добавить команду в мапу, которая находится в CommandManager
2. Создать класс в пакете command и использовать интерфейс Command

## Константы 
- MAX_COUNT_TASKS - максимально количество задач для одного пользователя