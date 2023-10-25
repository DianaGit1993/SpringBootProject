package org.example.repository;

import org.example.model.Recipe;

import java.util.List;

public class RecipeRepository
{
    Recipe recipe1=new Recipe("Ochiuri cu branza si spanac",
            "2 oua,30 g de branza,o mana de frunze de spanac",
            "Bate cele două ouă într-un bol.\n" +
                      "Adaugă brânza rasă în ouă și amestecă bine.\n" +
                      "Încinge o tigaie antiaderentă la foc mediu și adaugă frunzele de spanac. Gatiti-le pana cand se înmoaie.\n" +
                      "Toarnă amestecul de ouă și brânză peste spanac în tigaie.\n" +
                      "Gatiti omleta timp de 2-3 minute pe fiecare parte sau până când este coaptă după preferința ta. Servește-o caldă",
            "15 minute");
    Recipe recipe2=new Recipe("Smoothie cu banane și căpșuni",
            "2 banane coapte\n" +
                    "1 cană de căpșuni proaspete sau congelate\n" +
                    "1 cană de lapte sau lapte de migdale",
            "Taie bananele și căpșunile în bucăți mai mici.\n" +
                    "Pune fructele tăiate într-un blender.\n" +
                    "Adaugă laptele sau laptele de migdale în blender.\n" +
                    "Amestecă toate ingredientele până obții un smoothie cremos.\n" +
                    "Servește smoothie-ul imediat sau păstrează-l în frigider pentru mai târziu.",
            "5 minute");
    Recipe recipe3=new Recipe("Salată Caprese",
            "2 roșii mari\n" +
                    "100 grame de mozzarella proaspătă\n" +
                    "O mână de frunze proaspete de busuioc",
            "Taie roșiile și mozzarella în felii subțiri.\n" +
                    "Așează alternativ feliile de roșii și mozzarella pe un platou.\n" +
                    "Presară frunzele proaspete de busuioc deasupra.\n" +
                    "Poți stropi salata cu puțin ulei de măsline și oțet balsamic, dacă dorești.\n" +
                    "Servește salata Caprese ca aperitiv sau alături de felul principal."
    ,"10 minute");
    public List<Recipe> fiindUsersByName(String Name)
    {
        //run sql query
        return List.of(recipe1,recipe2,recipe3);
    }


}
