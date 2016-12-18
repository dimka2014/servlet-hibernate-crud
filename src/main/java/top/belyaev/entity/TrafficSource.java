package top.belyaev.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "traffic_source")
@Data
public class TrafficSource {
    enum TrafficSourceType {
        WEB, MOBILE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @Column
    public String title;

    @Column
    public String url;

    @Column
    public float cost;

    @Column
    @Enumerated(EnumType.STRING)
    public TrafficSourceType type;

    @Override
    public String toString() {
        return "TrafficSource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", cost=" + cost +
                ", type=" + type +
                '}';
    }
}
