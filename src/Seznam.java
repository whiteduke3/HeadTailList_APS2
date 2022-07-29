
public class Seznam {
    public Elt elt;
    public Seznam rep;
    static int primerjave = 0;

    public Seznam(Elt elt, Seznam rep) {
        this.elt = elt;
        this.rep = rep;
    }

    static Seznam insert(Seznam s, Elt e) {
        Elt x = find(s, e.key);
        if(s == null || x == null) {
            return new Seznam(e, s);
        }
        x.data = e.data;
        return s;

    }

    static Elt find(Seznam s, int key) {
        if (s == null) {
            return null;
        }
        primerjave++;
        if(s.elt.key == key) {
            return s.elt;
        } else {
            return find(s.rep, key);
        }
    }

    static Seznam delete(Seznam s, int key) {
        if (s == null) return null;
        primerjave++;
        if(s.elt.key == key) {
            return s.rep;
        } else {
            return new Seznam(s.elt, delete(s.rep, key));
        }
    }

    static void printElementKeys(Seznam s) {
        if (s == null) return;
        System.out.println(s.elt.key);
        printElementKeys(s.rep);
    }
    static void printElementKeyComparisons(Seznam s) {
        if (s == null) return;
        System.out.println(primerjave);
    }
}
