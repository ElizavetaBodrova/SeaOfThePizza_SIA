package lizun.model;


import javax.persistence.*;

@Table(name="FEEDBACK")
public class Feedback {

    @Id
    @Column(name="ID")
    Integer id;
}
