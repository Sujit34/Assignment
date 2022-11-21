let p = class{
    constructor(name, price, desc,id){
        this.name = name;    
        this.price = price;
        this.desc = desc;
        this.id = id;
    }

    toString(){
        return "id: " + this.id
        + ", Description: " + this.desc
        + ", Price: $" + this.price;
    }
}

module.exports = p;