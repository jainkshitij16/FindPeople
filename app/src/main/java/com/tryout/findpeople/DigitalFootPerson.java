package com.tryout.findpeople;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kshitij on 2017-03-26.
 */
public class DigitalFootPerson {
    private ScoreDigital scoreDigital;
    private TopicDigital topicDigital;
    public List<ScoreDigital> scoreDigitalList;
    public List<TopicDigital> topicDigitalList;


    public DigitalFootPerson(){
        this.scoreDigitalList = new ArrayList<>();
        this.topicDigitalList = new ArrayList<>();
    }

    public DigitalFootPerson(ScoreDigital scoreDigital){
        this.scoreDigital = scoreDigital;
        this.scoreDigitalList = new ArrayList<>();
        this.topicDigitalList = new ArrayList<>();

    }

    public DigitalFootPerson(TopicDigital topicDigital){
        this.topicDigital = topicDigital;
        this.scoreDigitalList = new ArrayList<>();
        this.topicDigitalList = new ArrayList<>();
    }

    public ScoreDigital getScoreDigital() {
        return scoreDigital;
    }

    public void setScoreDigital(ScoreDigital scoreDigital) {
        this.scoreDigital = scoreDigital;
    }

    public TopicDigital getTopicDigital() {
        return topicDigital;
    }

    public void setTopicDigital(TopicDigital topicDigital) {
        this.topicDigital = topicDigital;
    }

    public List<ScoreDigital> getScoreDigitalList() {
        return scoreDigitalList;
    }

    public void setScoreDigitalList(List<ScoreDigital> scoreDigitalList) {
        this.scoreDigitalList = scoreDigitalList;
    }

    public List<TopicDigital> getTopicDigitalList() {
        return topicDigitalList;
    }

    public void setTopicDigitalList(List<TopicDigital> topicDigitalList) {
        this.topicDigitalList = topicDigitalList;
    }
}
