Создан форк репозитория KAS2020. Произведено клонирование форка на локальный компьютер. Репозиторий BREWYM/KotlinAsFirst2021 выбран,
как upstream-my. Сделан fetch апстрима.
Далее переходим на ветку backport. Сделан cherrypick коммитов в upstream-my от d535f359 до FETCH_HEAD текущего апстрима.
В качестве upstream-theirs выбран PurpleLimon/KotlinAsFirst2021. Сделан fetch этого upstream-theirs.
Переход на ветку master. Слияние (merge) веток master, backport и upstream-theirs в master. Исправление конфликтов. Слияние.
Перевод апстримов в remotes и создание коммита с изменениями
