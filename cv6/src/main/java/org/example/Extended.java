package org.example;

import java.util.Random;

class ExtraNevhodnaOsoba extends Osoba {
    @Override
    public int hashCode() {
        return 5;
    }
}

class NevhodnaOsoba extends Osoba {
    private final int nahodnaPromenna = new Random().nextInt(100);

    @Override
    public int hashCode() {
        return nahodnaPromenna;
    }
}

class PrijatelnaOsoba extends Osoba {
    @Override
    public int hashCode() {
        return 42;
    }
}

class PerfektniOsoba extends Osoba {
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class ObjectsHashOsoba extends Osoba {
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode());
    }
}

class VlastniObjectsHashOsoba extends Osoba {
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
