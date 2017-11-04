package tev.community.test.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by evg_uh on 04.11.17.
 */
@Entity
@Table(name = "test_interval")
public class TestInterval {

    public TestInterval() {

    }

    public TestInterval(Integer startI, Integer endI) {
        this.startI = startI;
        this.endI = endI;
    }

    @Id
    @SequenceGenerator(name = "test_interval_id_seq", sequenceName = "test_interval_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_interval_id_seq")
    @Column(name = "tsti_id")
    @Access(value = AccessType.PROPERTY)
    private Integer id;

    @Column(name = "start_i", nullable = false)
    @NotNull
    private Integer startI;

    @Column(name = "end_i", nullable = false)
    @NotNull
    private Integer endI;

    public Integer getStartI() {
        return startI;
    }

    public void setStartI(Integer startI) {
        this.startI = startI;
    }

    public Integer getEndI() {
        return endI;
    }

    public void setEndI(Integer endI) {
        this.endI = endI;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestInterval{" +
                "id=" + id +
                ", startI=" + startI +
                ", endI=" + endI +
                '}';
    }
}
