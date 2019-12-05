public abstract class person {
    protected String name;
    protected String email;
    protected String phone;
    protected String nationality;
    protected int age;
    protected Data person_Data;
    protected int id;
    
    public person (){
        person_Data = new Data();
    }

    public Data getPerson_Data() {
        return person_Data;
    }

    public void setPerson_Data(Data person_Data) {
        this.person_Data = person_Data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    abstract void add ();
    
    abstract void update ();
    
    abstract void delete (int id);
}
