import java.util.List;

public class ResponseData {
    public String email;
    public String name;
    public List<TaskObj> tasks;
    public List<CompaniesObj> companies;
    public String hobby;
    public String adres;
    public String name1;
    public String surname1;
    public String fathername1;
    public String cat;
    public String dog;
    public String parrot;
    public String cavy;
    public String hamster;
    public String squirrel;
    public String phone;
    public String inn;
    public String gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskObj> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskObj> tasks) {
        this.tasks = tasks;
    }

    public List<CompaniesObj> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompaniesObj> companies) {
        this.companies = companies;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getFathername1() {
        return fathername1;
    }

    public void setFathername1(String fathername1) {
        this.fathername1 = fathername1;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    public String getParrot() {
        return parrot;
    }

    public void setParrot(String parrot) {
        this.parrot = parrot;
    }

    public String getCavy() {
        return cavy;
    }

    public void setCavy(String cavy) {
        this.cavy = cavy;
    }

    public String getHamster() {
        return hamster;
    }

    public void setHamster(String hamster) {
        this.hamster = hamster;
    }

    public String getSquirrel() {
        return squirrel;
    }

    public void setSquirrel(String squirrel) {
        this.squirrel = squirrel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                ", companies=" + companies +
                ", hobby='" + hobby + '\'' +
                ", adres='" + adres + '\'' +
                ", name1='" + name1 + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", fathername1='" + fathername1 + '\'' +
                ", cat='" + cat + '\'' +
                ", dog='" + dog + '\'' +
                ", parrot='" + parrot + '\'' +
                ", cavy='" + cavy + '\'' +
                ", hamster='" + hamster + '\'' +
                ", squirrel='" + squirrel + '\'' +
                ", phone='" + phone + '\'' +
                ", inn='" + inn + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
