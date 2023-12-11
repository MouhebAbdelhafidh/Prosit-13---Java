package levels;

import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> employees = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        employees.stream().forEach(System.out::println);

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        employees.stream().filter(s -> s.getName().startsWith("n")).forEach(System.out::println);

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        employees.stream().filter(s -> s.getName().startsWith("n")).filter(teacher -> teacher.getSalary() > 100000).forEach(System.out::println);

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        Predicate<Teacher> isUnique = new Predicate<>() {
            @Override
            public boolean test(Teacher t) {
                return employees.indexOf(t) == employees.lastIndexOf(t);
            }
        };
        employees.stream().filter(isUnique).sorted().forEach(System.out::println);

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        employees.stream().filter(teacher -> teacher.getSalary() > 60000).forEach(System.out::println);
        /* Second Way */
        //employees.stream().filter(teacher -> teacher.getSalary() > 60000).map(/* TO DO 5 */).forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        employees.stream().filter(s -> s.getName().startsWith("m")).forEach(s -> s.setSalary(s.getSalary()+200));

    }
}
