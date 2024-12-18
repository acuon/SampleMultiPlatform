//
//  DataUtils.swift
//  iosApp
//
//  Created by Rohit's Macbook on 18/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct DataUtils {
    static let tasksList: [TaskModel] = [
        TaskModel(
            title: "Physical Activity",
            description: "I would like to run in the morning before work.",
            progress: 0.0,
            isCompleted: false,
            sideColor: Color.blue,
            showTaskProgress: true,
            completedTasks: 1,
            totalTasks: 4,
            taskPoints: 2
        ),
        TaskModel(
            title: "Meal rhythm",
            description: nil,
            progress: 0.25,
            isCompleted: false,
            sideColor: Color.purple,
            showTaskProgress: true,
            completedTasks: nil,
            totalTasks: 3,
            taskPoints: 0
        ),
        TaskModel(
            title: "Longer survey title",
            description: "Survey • Sep 30",
            progress: 0.0,
            isCompleted: true,
            sideColor: Color.yellow,
            showTaskProgress: false,
            completedTasks: nil,
            totalTasks: 1,
            taskPoints: 2,
            taskType: "Survey",
            endDate: "Sep 30"
        )
    ]
    
    static let nutrientList: [NutrientModel] = [
        NutrientModel(
            label: "Carbohydrate",
            icon: "meal_icon_carb",
            quantityInPercentage: 50,
            quantityInGm: 12,
            nutrientBreakDown: [
                NutrientBreakDown(label: "Sugars", quantityInPercentage: 10, quantityInGm: 2),
                NutrientBreakDown(label: "Fiber", quantityInPercentage: 5, quantityInGm: 2),
                NutrientBreakDown(label: "Starch", quantityInPercentage: 35, quantityInGm: 8)
            ]
        ),
        NutrientModel(
            label: "Fat",
            icon: "meal_icon_fat",
            quantityInPercentage: 30,
            quantityInGm: 12,
            nutrientBreakDown: [
                NutrientBreakDown(label: "Saturated Fat", quantityInPercentage: 5, quantityInGm: 2),
                NutrientBreakDown(label: "Unsaturated Fat", quantityInPercentage: 25, quantityInGm: 10)
            ]
        ),
        NutrientModel(
            label: "Protein",
            icon: "meal_icon_protein",
            quantityInPercentage: nil,
            quantityInGm: 12,
            nutrientBreakDown: nil
        ),
        NutrientModel(
            label: "Total energy",
            icon: "meal_icon_energy",
            quantityInPercentage: nil,
            quantityInGm: 0,
            quantityInKcal: 300,
            nutrientBreakDown: nil
        )
    ]
}
