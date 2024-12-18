//
//  HomeScreen.swift
//  iosApp
//
//  Created by Rohit's Macbook on 17/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Shared
import Foundation
import SwiftUI

struct HomeScreen: View {
    
    @ObservedObject var viewModel: SampleViewModel = SampleViewModel()
    
    var body: some View {
        ScrollView {
            VStack(spacing: 16) {
                UserGreetingView()
                    .background(Color.white)
                    .cornerRadius(8)
                
                DailyCheckInCardView()
                
                TasksSectionView()
            }
            .padding()
            .background(Color(red: 0.92, green: 0.94, blue: 0.97))
        }
    }
}

struct UserGreetingView: View {
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text("Good morning, Jeanette!")
                .font(.title)
                .fontWeight(.bold)
                .padding(.top, 16)
                .padding(.horizontal, 16)
            
            HStack(spacing: 8) {
                Image(systemName: "person.crop.circle.fill")
                    .resizable()
                    .frame(width: 64, height: 64)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                
                Text("Great that you're here, you have 5 new tasks.")
                    .font(.body)
            }
            .padding(.horizontal, 16)
            .padding(.bottom, 16)
        }
        .background(Color.white)
        .cornerRadius(16, antialiased: true)
    }
}

struct DailyCheckInCardView: View {
    var body: some View {
        VStack(alignment: .leading, spacing: 12) {
            HStack {
                Text("My daily check-in")
                    .font(.headline)
                
                Spacer()
                
                Text("more")
                    .font(.subheadline)
            }
            
            HStack {
                Image(systemName: "chevron.left")
                    .frame(width: 24, height: 24)
                    .background(Color.white)
                    .cornerRadius(12)
                
                Text("Wed, 22 Apr 2022")
                    .font(.subheadline)
                
                Image(systemName: "chevron.right")
                    .frame(width: 24, height: 24)
                    .background(Color.white)
                    .cornerRadius(12)
            }
            
            ForEach(0..<5) { _ in
                DailyCheckInItem(label: "Item Label", isCompleted: false, checkInIcon: "star")
            }
        }
        .padding()
    }
}

struct DailyCheckInItem: View {
    var label: String
    var isCompleted: Bool
    var checkInIcon: String
    
    var body: some View {
        HStack {
            Image(systemName: checkInIcon)
                .frame(width: 24, height: 24)
                .background(Color.gray)
                .cornerRadius(12)
            
            Text(label)
            
            Spacer()
        }
        .padding()
        .background(Color.white)
        .cornerRadius(8)
    }
}

struct TasksSectionView: View {
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text("My tasks")
                .font(.headline)
            
            ForEach(0..<5) { _ in
                TaskItem()
            }
        }
        .padding()
    }
}

struct TaskItem: View {
    var body: some View {
        HStack {
            CircularTaskProgress(completedTasks: 3, totalTasks: 5)
            
            VStack(alignment: .leading) {
                Text("Task Title")
                    .font(.headline)
                
                Text("Task Description")
                    .font(.caption)
            }
            
            Spacer()
            
            Text("Points")
                .font(.caption)
        }
        .padding()
        .background(Color.white)
        .cornerRadius(8)
    }
}

struct CircularTaskProgress: View {
    var completedTasks: Int
    var totalTasks: Int
    
    var body: some View {
        VStack {
            ZStack {
                Circle()
                    .trim(from: 0, to: CGFloat(completedTasks/totalTasks))
                    .stroke(Color.orange, lineWidth: 4)
                    .rotationEffect(.degrees(-90))
                    .frame(width: 50, height: 50)
                
                Image(systemName: "checkmark.circle")
                    .foregroundColor(.gray)
            }
            .padding(.bottom, 4)
            
            Text("\(completedTasks)/\(totalTasks)")
                .font(.caption)
                .foregroundColor(.black)
                .padding(.vertical, 4)
                .padding(.horizontal, 8)
                .background(Color(UIColor.systemGray6))
                .cornerRadius(6)
        }
    }
}

struct CircularProgressBarWithText: View {
    var progress: Float
    var text: String
    
    var body: some View {
        ZStack {
            Circle()
                .trim(from: 0, to: CGFloat(progress))
                .stroke(Color.orange, lineWidth: 4)
                .rotationEffect(.degrees(-90))
                .frame(width: 50, height: 50)
            
            Text("\(Int(progress * 100))%")
                .font(.caption)
                .foregroundColor(.black)
        }
    }
}

struct ProgressView: View {
    
    @ObservedObject var viewModel: SampleViewModel = SampleViewModel()
    
    var body: some View {
        ScrollView {
            VStack(spacing: 16) {
                UserGreetingView()
                DailyCheckInCardView()
                TasksSectionView()
            }
            .background(Color(red: 235/255, green: 239/255, blue: 248/255))
        }
    }
}

