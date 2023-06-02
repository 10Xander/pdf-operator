package com.editor.test.pdfbox;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\r\n" + "	\"status\": \"success\",\r\n" + "	\"data\": {\r\n" + "		\"name\": {\r\n"
				+ "			\"full_name\": \"Brendan Herger\",\r\n" + "			\"first_name\": \"Brendan\",\r\n"
				+ "			\"last_name\": \"Herger\"\r\n" + "		},\r\n" + "		\"email\": [{\r\n"
				+ "			\"email\": \"13herger@gmail.com\"\r\n" + "		}],\r\n" + "		\"employer\": [{\r\n"
				+ "			\"role\": \"Data\",\r\n" + "			\"from_year\": 2015,\r\n"
				+ "			\"from_month\": 6,\r\n" + "			\"is_current\": true,\r\n"
				+ "			\"description\": \"Lead research team modeling for fraud problem space with class\\nimbalance & adversaries; H2O.ai, GraphLab, SKLearn\\nDeployed sub-millisecond real time model; Apache Apex\\nRecommended distributed machine learning frameworks for general\\nadoption at Capital One; H2O.ai, GraphLab, Apache Spark\\nVarious Technical Positions\\nLawfty (San Francisco, Ca.), RevUp Software (Redwood City, Ca.),\\nPerkins + Will Architecture (San Francisco, Ca.) & Lawrence Berkeley\\nNational Lab. (Berkeley, Ca.)\\nFront End Supervisor\",\r\n"
				+ "			\"skills\": [\"Research\", \"Modeling\", \"Artificial Intelligence\", \"Graphlab\", \"MVVM\", \"Apache Software\", \"Distributed Computing\", \"Machine Learning\", \"Software Framework\", \"Adoptions\", \"Artificial Intelligence\", \"Graphlab\", \"Apache Spark\", \"Architecture\", \"Front End (Software Engineering)\"]\r\n"
				+ "		}, {\r\n" + "			\"company_name\": \"The Home Depot Pro\",\r\n"
				+ "			\"from_year\": 2011,\r\n" + "			\"from_month\": 5,\r\n"
				+ "			\"to_year\": 2013,\r\n" + "			\"to_month\": 3,\r\n"
				+ "			\"description\": \"Positions held: Cashier, Special Services Assoc., Tool Rental Assoc.\\nSupervised and trained a staff of 10-30 team members\"\r\n"
				+ "		}],\r\n" + "		\"total_experience\": {\r\n" + "			\"years\": 9,\r\n"
				+ "			\"months\": 9\r\n" + "		},\r\n" + "		\"education\": [{\r\n"
				+ "			\"institute\": \"University Of San Francisco\",\r\n" + "			\"degree\": \"Ms\",\r\n"
				+ "			\"course\": \"Analytics\",\r\n" + "			\"to_year\": 2015,\r\n"
				+ "			\"to_month\": 7\r\n" + "		}, {\r\n"
				+ "			\"institute\": \"University Of San Francisco\",\r\n" + "			\"degree\": \"Bs\",\r\n"
				+ "			\"course\": \"Physics\",\r\n" + "			\"to_year\": 2014,\r\n"
				+ "			\"to_month\": 5\r\n" + "		}],\r\n" + "		\"phone\": [{\r\n"
				+ "			\"phone\": \"+1 415-582-7457\"\r\n" + "		}],\r\n"
				+ "		\"personal_details_heading\": \"Personal Projects\\nIdentified genre of Billboard\\nHot 100 songs using ensemble\\nalgorithm built with Support\\nVector Machine, Neural Network,\\nStochastic Gradient Boost, and\\nRandom Forest algorithms;\\nPython, Pandas, R and Scikit-Learn\\nImplemented Naive Bayes text\\nclassification algorithm and trained\\nthis algorithm to correctly label\\n83% of movie reviews; Python,\\nnumpy and Pandas\\nCreated database containing lyrics\\nof Billboard Hot 100 songs since\\n1958; R, Python, Pandas and\\nBeautiful Soup 4\\nBuilt a multi-threaded web scraper\\nand search engine with web\\nuser interface; Java, MySQL and\\nHTML5/CSS\\nBuilt resume parsing package\\nwhich extracts text, finds contact\\ndetails, and checks for required\\nkeywords; Python and Pandas\\nOnline\\nHergertarian.com\\ngithub.com/bjherger\\nlinkedin.com/in/bjherger\\nhergertarian.wordpress.com/\",\r\n"
				+ "		\"personal_details_top_heading\": \"Brendan Herger\\nHergertarian.com | 13herger@gmail.com | + 1 (415) 582-7457\\n1209 Page Street No. 7 San Francisco, Ca 94117\",\r\n"
				+ "		\"address\": {\r\n" + "			\"city\": \"san francisco\",\r\n"
				+ "			\"country_code\": \"US\",\r\n" + "			\"_source\": \"personal_details_top\"\r\n"
				+ "		},\r\n"
				+ "		\"personal_urls\": [\"hergertarian.wordpress.com/\", \"hergertarian.com\", \"github.com/bjherger\", \"linkedin.com/in/bjherger\"],\r\n"
				+ "		\"generated_summary_text\": \"The candidate comes with 9.5+ years of experience, and has worked with employers like The Home Depot Pro.\",\r\n"
				+ "		\"total_time\": 0.7231521606445312,\r\n" + "		\"features\": {\r\n"
				+ "			\"0\": [\"multicolumn_exist\"]\r\n" + "		},\r\n" + "		\"skills\": {\r\n"
				+ "			\"skills_meta\": [{\r\n" + "				\"display_name\": \"Architecture\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Machine Learning\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Apache Software\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Graphlab\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Apache Spark\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Artificial Intelligence\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"MVVM\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Software Framework\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Modeling\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Adoptions\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Distributed Computing\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Research\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}, {\r\n" + "				\"display_name\": \"Front End (Software Engineering)\",\r\n"
				+ "				\"experience\": 94.87,\r\n"
				+ "				\"last_used_on\": \"2023-03-17T00:00:00\",\r\n" + "				\"timeline\": [{\r\n"
				+ "					\"from_date\": \"2015-06-01T00:00:00\",\r\n"
				+ "					\"to_date\": \"2023-03-17T00:00:00\",\r\n"
				+ "					\"source\": [\"employer_description_skills\"]\r\n" + "				}]\r\n"
				+ "			}],\r\n"
				+ "			\"overall_skills\": [\"Adoptions\", \"Apache Software\", \"Apache Spark\", \"Architecture\", \"Artificial Intelligence\", \"Distributed Computing\", \"Front End (Software Engineering)\", \"Graphlab\", \"MVVM\", \"Machine Learning\", \"Modeling\", \"Research\", \"Software Framework\"]\r\n"
				+ "		}\r\n" + "	},\r\n" + "	\"total_time\": 0.7360155582427979\r\n" + "}";

		getParser(json);

	}

	public static String getParser(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		if (!jsonNode.findValue("status").asText().equalsIgnoreCase("success")) {
			System.out.println("status");
		}

		// firstName
		if (jsonNode.findValue("first_name") != null) {
			String firstName = jsonNode.findValue("first_name").asText();
			System.out.println(firstName);
		}
		// lastNmae
		if (jsonNode.findValue("last_name") != null) {
			String lastName = jsonNode.findValue("last_name").asText();
			System.out.println(lastName);
		}
		// email
		if (jsonNode.findValue("email") != null) {
			String email = jsonNode.findValue("email").toString();
			JsonNode emailNode = objectMapper.readTree(email);
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < emailNode.size(); i++) {
				JsonNode node = objectMapper.readTree(emailNode.get(i).toString());
				String emailAddress = node.findValue("email").asText();
				buffer.append(emailAddress);
				if (i < emailNode.size() - 1)
					buffer.append(" | ");
			}
			System.out.println(buffer.toString());
		}
		// phone
		if (jsonNode.findValue("phone") != null) {
			String phone = jsonNode.findValue("phone").toString();
			JsonNode phoneNode = objectMapper.readTree(phone);
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < phoneNode.size(); i++) {
				JsonNode node = objectMapper.readTree(phoneNode.get(i).toString());
				String phoneNumber = node.findValue("phone").asText();
				buffer.append(phoneNumber);
				if (i < phoneNode.size() - 1)
					buffer.append(" | ");
			}
			System.out.println(buffer.toString());
		}
		// address
		if (jsonNode.findValue("address") != null) {
			String address = jsonNode.findValue("address").toString();
			JsonNode addressNode = objectMapper.readTree(address);
			StringBuffer buffer = new StringBuffer();
			if (addressNode.findValue("city") != null) {
				buffer.append("city:" + addressNode.findValue("city").asText() + ",");
			}
			if (addressNode.findValue("country_code") != null) {
				buffer.append("country_code:" + addressNode.findValue("country_code").asText() + ",");
			}
			if (addressNode.findValue("_source") != null) {
				buffer.append("_source:" + addressNode.findValue("_source").asText());
			}
			System.out.println(buffer.toString());
		}
		// gender
		if (jsonNode.findValue("gender") != null) {
			String gender = jsonNode.findValue("gender").asText();
			System.out.println(gender);
		}
		// jobTitle
		if (jsonNode.findValue("title") != null) {
			String title = jsonNode.findValue("title").asText();
			System.out.println(title);
		}
		// skills
		if (jsonNode.findValue("overall_skills") != null) {
			String skills = jsonNode.findValue("overall_skills").toString();
			JsonNode skillsNode = objectMapper.readTree(skills);
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < skillsNode.size(); i++) {
				buffer.append(skillsNode.get(i).asText());
				if (i < skillsNode.size() - 1)
					buffer.append(",");
			}
			System.out.println(buffer.toString());
		}
		// generated_summary_text
		if (jsonNode.findValue("generated_summary_text") != null) {
			String summary = jsonNode.findValue("generated_summary_text").asText();
			System.out.println(summary);
		}
		// work_experience
		if (jsonNode.findValue("employer") != null) {
			String experiences = jsonNode.findValue("employer").toString();
			JsonNode experiencesNode = objectMapper.readTree(experiences);
			List<WorkExperience> list = new ArrayList<WorkExperience>();
			for (int i = 0; i < experiencesNode.size(); i++) {
				String experience = experiencesNode.get(i).toString();
				JsonNode experienceNode = objectMapper.readTree(experience);
				WorkExperience work = new WorkExperience();
				if (experienceNode.findValue("role") != null)
					work.setJobTitle(experienceNode.findValue("role").asText());
				if (experienceNode.findValue("from_year") != null && experienceNode.findValue("from_month") != null)
					work.setStartTime(experienceNode.findValue("from_year").asText()+"-"+experienceNode.findValue("from_month").asText());
				if (experienceNode.findValue("to_year") != null && experienceNode.findValue("to_month") != null)
					work.setEndTime(experienceNode.findValue("to_year").asText()+"-"+experienceNode.findValue("to_month").asText());
				if (experienceNode.findValue("company_name") != null)
					work.setOrganization(experienceNode.findValue("company_name").asText());
				if (experienceNode.findValue("description") != null)
					work.setContent(experienceNode.findValue("description").asText());
				System.out.println(work.getOrganization());
				list.add(work);
			}
		}

		// education
		if (jsonNode.findValue("education") != null) {
			String educations = jsonNode.findValue("education").toString();
			JsonNode educationsJsonNode = objectMapper.readTree(educations);
			List<EducationAndTraining> list = new ArrayList<EducationAndTraining>();
			for (int i = 0; i < educationsJsonNode.size(); i++) {
				String education = educationsJsonNode.get(i).toString();
				JsonNode educationNode = objectMapper.readTree(education);
				EducationAndTraining edu = new EducationAndTraining();
				if (educationNode.findValue("institute") != null)
					edu.setOrganization(educationNode.findValue("institute").asText());
				if (educationNode.findValue("from_year") != null && educationNode.findValue("from_month") != null)
					edu.setStartTime(educationNode.findValue("from_year").asText()+"-"+educationNode.findValue("from_month").asText());
				if (educationNode.findValue("to_year") != null && educationNode.findValue("to_month") != null)
					edu.setEndTime(educationNode.findValue("to_year").asText()+"-"+educationNode.findValue("to_month").asText());
				if (educationNode.findValue("degree") != null)
					edu.setDegree(educationNode.findValue("degree").asText());
				if (educationNode.findValue("course") != null)
					edu.setMajor(educationNode.findValue("course").asText());
				System.out.println(edu.getOrganization());
				list.add(edu);
			}
		}
		
		//Projects
		if (jsonNode.findValue("projects") != null) {
			String projects = jsonNode.findValue("projects").toString();
			JsonNode projectsNode = objectMapper.readTree(projects);
			List<ProjectExperience> list = new ArrayList<ProjectExperience>();
			for (int i = 0; i < projectsNode.size(); i++) {
				String project = projectsNode.get(i).toString();
				JsonNode projectNode = objectMapper.readTree(project);
				ProjectExperience pro = new ProjectExperience();
				if (projectNode.findValue("description") != null)
					pro.setContent(projectNode.findValue("description").asText());
				System.out.println("xiangm:"+projectNode.findValue("description").asText());
				list.add(pro);
			}
//			resume.setProjectExperiences(list);
		}
		return null;
	}

}
