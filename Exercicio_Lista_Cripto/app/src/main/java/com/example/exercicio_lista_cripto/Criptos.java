package com.example.exercicio_lista_cripto;
import java.util.ArrayList;
import java.util.List;

public class Criptos {
    public String name;
    public String cod;
    public int img;

    public Criptos(String name, String cod, int img) {
        this.name = name;
        this.cod = cod;
        this.img = img;
    }

    public static List<Criptos> getCriptos(){
        List<Criptos> criptos = new ArrayList<>();
        criptos.add(new Criptos("Bitcoin", "BTC", R.drawable.bitcoin));
        criptos.add(new Criptos("Ethereum", "ETH", R.drawable.ethereum));
        criptos.add(new Criptos("Binance Coin", "BNB", R.drawable.binancecoin));
        criptos.add(new Criptos("Solana", "SOL", R.drawable.solana));
        criptos.add(new Criptos("Dogecoin", "DOGE", R.drawable.dogecoin));
        criptos.add(new Criptos("XRP", "XRP", R.drawable.xrp));
        criptos.add(new Criptos("Polkadot", "DTO", R.drawable.polkadot));
        criptos.add(new Criptos("Uniswap","UNI", R.drawable.uniswap));
        criptos.add(new Criptos("Litecoin","LTC", R.drawable.litecoin));
        criptos.add(new Criptos("Shiba Inu","SHIB", R.drawable.shiba));
        criptos.add(new Criptos("Tether USDt","USDT", R.drawable.tether));
        criptos.add(new Criptos("Pepe","PEPE", R.drawable.pepe));
        return criptos;
    }
}
