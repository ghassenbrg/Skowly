package com.skowly.core.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.common.reflect.ClassPath;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlantUMLService {

	public String generatePlantUMLCode(String packageName) throws IOException {
		StringBuilder plantUMLCode = new StringBuilder("@startuml\n");

		// Use Guava's ClassPath to scan classes within the package
		ClassPath classPath = ClassPath.from(getClass().getClassLoader());
		Set<ClassPath.ClassInfo> classInfos = classPath.getTopLevelClassesRecursive(packageName);

		generateClassDefinitions(classInfos, plantUMLCode);
		generateRelationships(classInfos, plantUMLCode);

		plantUMLCode.append("@enduml");

		return plantUMLCode.toString();
	}

	private void generateClassDefinitions(Set<ClassPath.ClassInfo> classInfos, StringBuilder plantUMLCode) {
		for (ClassPath.ClassInfo classInfo : classInfos) {
			Class<?> clazz = classInfo.load();
			plantUMLCode.append("class ").append(clazz.getSimpleName()).append(" {\n");
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				plantUMLCode.append("  ").append(field.getType().getSimpleName()).append(" ").append(field.getName())
						.append("\n");
			}
			plantUMLCode.append("}\n");
		}
	}

	private void generateRelationships(Set<ClassPath.ClassInfo> classInfos, StringBuilder plantUMLCode) {
		for (ClassPath.ClassInfo classInfo : classInfos) {
			Class<?> clazz = classInfo.load();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				appendFieldRelationship(classInfos, plantUMLCode, clazz, field);
			}
		}
	}

	private void appendFieldRelationship(Set<ClassPath.ClassInfo> classInfos, StringBuilder plantUMLCode,
			Class<?> clazz, Field field) {
		String fieldTypeName = field.getType().getSimpleName();
		String cardinality = getCardinality(field);

		if (!cardinality.isEmpty()
				&& classInfos.stream().anyMatch(info -> info.getSimpleName().equals(fieldTypeName))) {
			plantUMLCode.append(clazz.getSimpleName()).append(cardinality).append(fieldTypeName).append(" : ")
					.append(field.getName()).append("\n");
		}
	}

	private String getCardinality(Field field) {
		if (field.isAnnotationPresent(OneToMany.class)) {
			return " \"1\" -- \"*\" ";
		} else if (field.isAnnotationPresent(ManyToOne.class)) {
			return " \"*\" -- \"1\" ";
		} else if (field.isAnnotationPresent(OneToOne.class)) {
			return " \"1\" -- \"1\" ";
		} else if (field.isAnnotationPresent(ManyToMany.class)) {
			return " \"*\" -- \"*\" ";
		}
		return "";
	}

}
