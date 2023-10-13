package io.jonas.quizapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity(name="QUESTZION")
public class Questzion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String question;
	@NonNull
	private String option1;
	@NonNull
	private String option2;
	@NonNull
	private String option3;
	@NonNull
	private String option4;
	@NonNull
	private String answer;

}
