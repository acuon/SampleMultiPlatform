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
                UserGreeting()
                DailyCheckInCard()
                TasksSection()
            }
            .background(Color(red: 235/255, green: 239/255, blue: 248/255))
        }
    }
}



struct ProgressView: View {
    
    @ObservedObject var viewModel: SampleViewModel = SampleViewModel()
    
    var body: some View {
        ScrollView {
            VStack(spacing: 16) {
                UserGreeting()
                DailyCheckInCard()
                TasksSection()
            }
            .background(Color(red: 235/255, green: 239/255, blue: 248/255))
        }
    }
}

