package com.example.finalchance;

public class Entity {
        String level, name, type, description,origin;
        int id;
        byte[] img;


        public Entity(int id, byte[] img, String name, String type, String description, String level, String origin){
            this.id = id;
            this.name = name;
            this.level = level;
            this.description = description;
            this.origin = origin;
            this.type = type;
            this.img = img;
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

}
