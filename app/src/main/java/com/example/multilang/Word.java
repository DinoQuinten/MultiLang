package com.example.multilang;

public class Word {

    private String mDefaultTranslation;
    private String mMultiLangTranslation;
    private int imageId=HAS_NO_IMAGE;
    private static byte HAS_NO_IMAGE=-1;
    private int sound;

//    @param DefaultTranslation is the deflault lang app is set in
//    @param MultiLangTranslation is the Teaslated lang
    public Word(String DefaultTranslation, String Multilangtranslation, int sound){
        mDefaultTranslation=DefaultTranslation;
        mMultiLangTranslation=Multilangtranslation;
        this.sound=sound;
    }

//    public Word(String DefaultTranslation, String Multilangtranslation){
//        mDefaultTranslation=DefaultTranslation;
//        mMultiLangTranslation=Multilangtranslation;
//    }

    public Word(String DefaultTranslation, String Multilangtranslation, int imageId,int sound){
        mDefaultTranslation=DefaultTranslation;
        mMultiLangTranslation=Multilangtranslation;
        this.imageId=imageId;
        this.sound=sound;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMultiLangTranslation(){
        return mMultiLangTranslation;
    }
    public int getImageId(){return imageId;}
    public  int getSound(){return sound;}
    public boolean hasImage(){
        return this.imageId!=HAS_NO_IMAGE;
    }
}
