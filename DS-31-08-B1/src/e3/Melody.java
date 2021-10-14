package e3;

public class Melody {

        enum Notes {DO,RE,MI,FA,SOL,LA,SI}
        enum Accidentals{
        NATURAL(""), SHARP("#"), FLAT("b");
        String simbolo;
        Accidentals(String simbolo){
            this.simbolo = simbolo;
        }
        }

        private Notes nota;
        private Accidentals alte;
        private float tiempo;
        Notes[] Notas;
        Accidentals[] Alte;
        float[] mili;
        int cont=0;
        float suma=0;

        public Melody () {
            Notas = new Notes[15];
            Alte = new Accidentals[15];
            mili = new float[15];
        }

        public void addNote ( Notes note , Accidentals accidental , float time ) {
            if(note==null || accidental==null || time <=0){
                throw new IllegalArgumentException();
            }
            this.nota=note;
            this.alte=accidental;
            this.tiempo=time;

            Notas[cont]=note;
            Alte[cont]=accidental;
            mili[cont]=time;

            cont++;
        }

        public Notes getNote ( int index ) {
            if(index>=cont){
                throw new IllegalArgumentException();
            }
            return Notas[index];
        }

        public Accidentals getAccidental (int index ) {
            if(index>=cont){
                throw new IllegalArgumentException();
            }
            return Alte[index];
        }

        public float getTime ( int index ) {
            if(index>=cont){
                throw new IllegalArgumentException();
            }
            return mili[index];
        }

        public int size () {
            return cont;
        }

        public float getDuration () {

            for(int k=0;k< mili.length;k++){
                suma=suma+mili[k];
            }
            return suma;
        }

    @Override
    public boolean equals (Object o) {
        int comp=0;
        if(!(o instanceof Melody melodia)) return false;
        if(this == melodia){ return true; }
        if(cont==0){
            return true;
        }else{
            for(int k=0;k<cont;k++) {
                if (((Notas[k] == Notes.DO && Alte[k] == Accidentals.SHARP) && (melodia.nota == Notes.RE && melodia.alte == Accidentals.FLAT)) ||
                        ((Notas[k] == Notes.RE && Alte[k] == Accidentals.FLAT) && (melodia.nota == Notes.DO && melodia.alte == Accidentals.SHARP))) {
                    int aux1=Notes.DO.hashCode();
                    aux1= Notes.RE.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.RE && Alte[k] == Accidentals.SHARP) && (melodia.nota == Notes.MI && melodia.alte == Accidentals.FLAT)) ||
                        ((Notas[k] == Notes.MI && Alte[k] == Accidentals.FLAT) && (melodia.nota == Notes.RE && melodia.alte == Accidentals.SHARP))) {
                    int aux1=Notes.RE.hashCode();
                    aux1= Notes.MI.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.MI && Alte[k] == Accidentals.NATURAL) && (melodia.nota == Notes.FA && melodia.alte == Accidentals.FLAT)) ||
                        ((Notas[k] == Notes.FA && Alte[k] == Accidentals.FLAT) && (melodia.nota == Notes.MI && melodia.alte == Accidentals.NATURAL))) {
                    int aux1=Notes.MI.hashCode();
                    aux1= Notes.FA.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.MI && Alte[k] == Accidentals.SHARP) && (melodia.nota == Notes.FA && melodia.alte == Accidentals.NATURAL)) ||
                        ((Notas[k] == Notes.FA && Alte[k] == Accidentals.NATURAL) && (melodia.nota == Notes.MI && melodia.alte == Accidentals.SHARP))) {
                    int aux1=Notes.MI.hashCode();
                    aux1= Notes.FA.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.FA && Alte[k] == Accidentals.SHARP) && (melodia.nota == Notes.SOL && melodia.alte == Accidentals.FLAT)) ||
                        ((Notas[k] == Notes.SOL && Alte[k] == Accidentals.FLAT) && (melodia.nota == Notes.FA && melodia.alte == Accidentals.SHARP))) {
                    int aux1=Notes.FA.hashCode();
                    aux1= Notes.SOL.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.SOL && Alte[k] == Accidentals.SHARP) && (melodia.nota == Notes.LA && melodia.alte == Accidentals.FLAT)) ||
                        ((Notas[k] == Notes.LA && Alte[k] == Accidentals.FLAT) && (melodia.nota == Notes.SOL && melodia.alte == Accidentals.SHARP))) {
                    int aux1=Notes.SOL.hashCode();
                    aux1= Notes.LA.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.LA && Alte[k] == Accidentals.SHARP) && (melodia.nota == Notes.SI && melodia.alte == Accidentals.FLAT)) ||
                        ((Notas[k] == Notes.SI && Alte[k] == Accidentals.FLAT) && (melodia.nota == Notes.LA && melodia.alte == Accidentals.SHARP))) {
                    int aux1=Notes.LA.hashCode();
                    aux1= Notes.SI.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.SI && Alte[k] == Accidentals.NATURAL) && (melodia.nota == Notes.DO && melodia.alte == Accidentals.FLAT)) ||
                        ((Notas[k] == Notes.DO && Alte[k] == Accidentals.FLAT) && (melodia.nota == Notes.SI && melodia.alte == Accidentals.NATURAL))) {
                    int aux1=Notes.SI.hashCode();
                    aux1= Notes.DO.hashCode();
                    return true;
                }
                if (((Notas[k] == Notes.SI && Alte[k] == Accidentals.SHARP) && (melodia.nota == Notes.DO && melodia.alte == Accidentals.NATURAL)) ||
                        ((Notas[k] == Notes.DO && Alte[k] == Accidentals.NATURAL) && (melodia.nota == Notes.SI && melodia.alte == Accidentals.SHARP))) {
                    int aux1=Notes.SI.hashCode();
                    aux1= Notes.DO.hashCode();
                    return true;
                }
                if(Notas[k]==melodia.Notas[k] && Alte[k]==melodia.Alte[k] && mili[k]==melodia.mili[k]){
                    comp++;
                }
            }
            if(comp==cont){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
            int result=size()+(int)getDuration()+Notes.DO.hashCode()+Notes.RE.hashCode()+Notes.MI.hashCode()+
                    Notes.FA.hashCode()+Notes.SOL.hashCode()+Notes.LA.hashCode()+Notes.SI.hashCode();
            result=result*31;
        return result;
    }

    @Override
        public String toString () {
            StringBuilder cadena=new StringBuilder();
            for(int k=0;k<cont;k++){
                cadena.append(Notas[k]).append(Alte[k].simbolo).append("(").append(mili[k]).append(")");
                if(k<cont-1){
                    cadena.append(" ");
                }
            }
            return cadena.toString();
        }
}
