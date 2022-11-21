let sc = class{
    constructor(name, price, desc,id,quantity){
        this.name = name;    
        this.price = price;
        this.desc = desc;
        this.id = id;
        this.quantity = quantity;
    }

    toString(){
        return "id: " + this.id
        + ", Description: " + this.desc
        + ", Quantity: " + this.quantity
        + ", Price: $" + this.price;
    }
}

module.exports = sc;