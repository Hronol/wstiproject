package com.company;

public class userService extends userData{

        private String nazwaUslugi, nazwaCzesci;
        private int liczenie;
        private double kwota1, kwota2;
        private int idUsera;

        public userService(){
                idUsera = getIdKlienta();
                nazwaCzesci = " ";
                nazwaUslugi = " ";
                liczenie = 0;
                kwota1 = 0.0;
                kwota2 = 0.0;
        }


        public String getNazwaUslugi() {
                return nazwaUslugi;
        }

        public void setNazwaUslugi(String nazwaUslugi) {
                this.nazwaUslugi = nazwaUslugi;
        }

        @Override
        public String getNazwaCzesci() {
                return nazwaCzesci;
        }

        @Override
        public void setNazwaCzesci(String nazwaCzesci) {
                this.nazwaCzesci = nazwaCzesci;
        }

        public int getLiczenie() {
                return liczenie;
        }

        public void setLiczenie(int liczenie) {
                this.liczenie = liczenie;
        }

        public double getKwota1() {
                return kwota1;
        }

        public void setKwota1(double kwota1) {
                this.kwota1 = kwota1;
        }

        public double getKwota2() {
                return kwota2;
        }

        public void setKwota2(double kwota2) {
                this.kwota2 = kwota2;
        }

        public int getIdUsera() {
                return idUsera;
        }

        public void setIdUsera(int idUsera) {
                this.idUsera = idUsera;
        }

}
