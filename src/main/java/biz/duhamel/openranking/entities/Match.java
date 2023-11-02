package biz.duhamel.openranking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.sql.Date;

@Entity(name="matchs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    private Date date;

    //@ManyToOne(cascade = CascadeType.PERSIST) // To use for creation in cascade of player, so no way ...
    @ManyToOne
    private User userId1;
    @ManyToOne
    private User userId2;
    @ManyToOne
    private User userIdWinner;

    private Byte scoreSet1Player1;
    private Byte scoreSet1Player2;
    private Byte scoreSet2Player1;
    private Byte scoreSet2Player2;
    private Byte scoreSet3Player1;
    private Byte scoreSet3Player2;

    public Match() {
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public User getPlayerId1() {
        return userId1;
    }

    public void setPlayerId1(User userId1) {
        this.userId1 = userId1;
    }

    public User getPlayerId2() {
        return userId2;
    }

    public void setPlayerId2(User userId2) {
        this.userId2 = userId2;
    }

    public User getPlayerIdWinner() {
        return userIdWinner;
    }

    public void setPlayerIdWinner(User userIdWinner) {
        this.userIdWinner = userIdWinner;
    }

    public Byte getScoreSet1Player1() {
        return scoreSet1Player1;
    }

    public void setScoreSet1Player1(Byte scoreSet1Player1) {
        this.scoreSet1Player1 = scoreSet1Player1;
    }

    public Byte getScoreSet1Player2() {
        return scoreSet1Player2;
    }

    public void setScoreSet1Player2(Byte scoreSet1Player2) {
        this.scoreSet1Player2 = scoreSet1Player2;
    }

    public Byte getScoreSet2Player1() {
        return scoreSet2Player1;
    }

    public void setScoreSet2Player1(Byte scoreSet2Player1) {
        this.scoreSet2Player1 = scoreSet2Player1;
    }

    public Byte getScoreSet2Player2() {
        return scoreSet2Player2;
    }

    public void setScoreSet2Player2(Byte scoreSet2Player2) {
        this.scoreSet2Player2 = scoreSet2Player2;
    }

    public Byte getScoreSet3Player1() {
        return scoreSet3Player1;
    }

    public void setScoreSet3Player1(Byte scoreSet3Player1) {
        this.scoreSet3Player1 = scoreSet3Player1;
    }

    public Byte getScoreSet3Player2() {
        return scoreSet3Player2;
    }

    public void setScoreSet3Player2(Byte scoreSet3Player2) {
        this.scoreSet3Player2 = scoreSet3Player2;
    }
}
