//
//  MealScreen.swift
//  iosApp
//
//  Created by Rohit's Macbook on 17/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import Shared

struct MealScreen: View {
    @State private var weight: Int = 0
    @State private var ratings: Int = 0
    let nutrientList = DataUtils.nutrientList

    var body: some View {
        ZStack {
            Color("F8F8F8")
                .edgesIgnoringSafeArea(.all)

            ScrollView {
                VStack(spacing: 16) {
                    HeaderView()

                    MealInfoView()

                    PortionView(weight: $weight)

                    NutrientsView(nutrients: nutrientList)

                    CompositionView(title: "Composition", proteins: 20, carbs: 50, fats: 30, total: 100)

                    RatingsView(rating: $ratings)
                }
                .padding(.bottom, 72)
            }

            SaveButton(weight: weight, ratings: ratings)
        }
    }
}

struct HeaderView: View {
    var body: some View {
        HStack {
            Button(action: { }) {
                Image(systemName: "arrow.left.circle.fill")
                    .foregroundColor(.white)
            }
            Spacer()
            Text("Meal")
                .foregroundColor(.white)
                .font(.system(size: 18))
            Spacer()
            Button(action: { }) {
                Image(systemName: "trash.fill")
                    .foregroundColor(.white)
            }
        }
        .padding(16)
        .background(Color("6A1B6A"))
    }
}

struct MealInfoView: View {
    var body: some View {
        VStack(spacing: 8) {
            HStack {
                VStack(alignment: .leading) {
                    Text("Raspberry cheesecake")
                        .font(.system(size: 20, weight: .bold))
                    RewardPointsView(points: "2")
                }
                Spacer()
                Image(systemName: "heart.fill")
                    .foregroundColor(.pink)
                    .padding(8)
                    .background(Color("EBEFF8"), in: Circle())
            }

            Image("image_raspberry")
                .resizable()
                .scaledToFill()
                .frame(height: 300)
                .cornerRadius(8)
        }
        .padding(16)
    }
}

struct RewardPointsView: View {
    let points: String
    
    var body: some View {
        HStack {
            Text(points)
                .font(.caption)
                .padding(.trailing, 3)
            Image(systemName: "diamond.fill")
                .foregroundColor(.orange)
        }
    }
}

struct PortionView: View {
    @Binding var weight: Int

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text("Portion")
                .font(.system(size: 16, weight: .bold))

            HStack {
                Button(action: {
                    if weight > 0 { weight -= 1 }
                }) {
                    Image(systemName: "minus.circle.fill")
                        .frame(width: 32, height: 32)
                        .background(Color("FFB100"), in: Circle())
                }

                TextField("Enter weight", value: $weight, formatter: NumberFormatter())
                    .padding()
                    .background(RoundedRectangle(cornerRadius: 24).stroke(Color.gray))

                Button(action: {
                    weight += 1
                }) {
                    Image(systemName: "plus.circle.fill")
                        .frame(width: 32, height: 32)
                        .background(Color("FFB100"), in: Circle())
                }
            }

            HStack {
                Image(systemName: "info.circle")
                Text("Tip! You can give me an approximate measure or you can ask me for a suggestion.")
                    .font(.system(size: 13))
                    .padding(.leading, 8)
            }
            .padding(.top, 8)
        }
        .padding(16)
    }
}

struct NutrientsView: View {
    var nutrients: [NutrientModel]

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text("Nutrients")
                .font(.system(size: 16, weight: .bold))

            ForEach(nutrients, id: \.label) { nutrient in
                NutrientRow(nutrient: nutrient)
            }
        }
        .padding(16)
    }
}

struct NutrientRow: View {
    var nutrient: NutrientModel

    var body: some View {
        VStack(alignment: .leading, spacing: 4) {
            HStack {
                Image(systemName: "leaf.fill")
                    .frame(width: 36, height: 36)
                Text(nutrient.label)
                    .font(.system(size: 14, weight: .bold))
                    .padding(.leading, 8)
                Spacer()
                Text("\(nutrient.quantityInKcal ?? 0) kcal")
                    .font(.system(size: 14, weight: .bold))
            }
            if let breakdowns = nutrient.nutrientBreakDown {
                ForEach(breakdowns, id: \.label) { item in
                    NutrientBreakDownRow(nutrient: item)
                }
            }
        }
        .padding(.vertical, 8)
    }
}

struct NutrientBreakDownRow: View {
    var nutrient: NutrientBreakDown

    var body: some View {
        HStack {
            Text(nutrient.label)
                .font(.system(size: 14))
            Spacer()
            Text("\(nutrient.quantityInKcal ?? 0) kcal")
                .font(.system(size: 14, weight: .bold))
        }
        .padding(.vertical, 4)
    }
}

struct CompositionView: View {
    var title: String
    var proteins: Float
    var carbs: Float
    var fats: Float
    var total: Float

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(title)
                .font(.system(size: 16, weight: .bold))

            HStack {
                Text("Proteins: \(proteins)g")
                Spacer()
                Text("Carbs: \(carbs)g")
                Spacer()
                Text("Fats: \(fats)g")
            }
            HStack {
                Text("Total: \(total)g")
                    .font(.system(size: 14, weight: .bold))
            }
        }
        .padding(16)
    }
}

struct RatingsView: View {
    @Binding var rating: Int

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text("Please rate your hunger before you started to eat")
                .font(.system(size: 14))

            HStack {
                ForEach(1...5, id: \.self) { num in
                    Button(action: {
                        rating = num
                    }) {
                        Image(systemName: num <= rating ? "star.fill" : "star")
                            .foregroundColor(.yellow)
                            .frame(width: 32, height: 32)
                    }
                }
            }
            .padding(.vertical, 8)
        }
        .padding(16)
    }
}

struct SaveButton: View {
    var weight: Int
    var ratings: Int

    var body: some View {
        Button(action: { }) {
            Text("Save")
                .foregroundColor(.black)
                .font(.system(size: 16))
        }
        .frame(maxWidth: .infinity)
        .padding()
        .background(weight > 0 && ratings > 0 ? Color("FFC107") : Color.gray)
        .cornerRadius(8)
        .padding(.horizontal, 16)
        .padding(.bottom, 24)
    }
}
