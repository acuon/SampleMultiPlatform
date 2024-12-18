//
//  MealModels.swift
//  iosApp
//
//  Created by Rohit's Macbook on 18/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct TaskModel {
    var title: String
    var description: String?
    var progress: CGFloat
    var isCompleted: Bool
    var sideColor: Color
    var showTaskProgress: Bool
    var completedTasks: Int?
    var totalTasks: Int
    var taskPoints: Int
    var taskType: String?
    var endDate: String?
}

struct NutrientBreakDown {
    var label: String
    var quantityInPercentage: Int?
    var quantityInGm: Int
    var quantityInKcal: Int?
}

struct NutrientModel {
    var label: String
    var icon: String
    var quantityInPercentage: Int?
    var quantityInGm: Int
    var quantityInKcal: Int?
    var nutrientBreakDown: [NutrientBreakDown]?
}
