- GM commands


- remove attack limitation
    1. use CheatEngine modify memory(00AFE8A0)(GMS079) of client


- Accomplish Quest / modify player bag
    1. Using HaRepacker, choose wz file and search quest keyword to get quest id
        or find quest id in server xml file
    2. Quest.wz, Act.img/7301 list all items needed for the quest
        or find items in server xml file
    3. add items into table `inventoryitems` (be careful)
