import SwiftUI
import Shared

struct ContentView: View {
    @State private var currentScreen: Screen = .main
    
    var body: some View {
        NavigationView {
            switch currentScreen {
                case .main:
                    MainScreen()
                    .navigationBarHidden(true)
                case .meal:
                    MealScreen()
                    .navigationBarHidden(true)
                default:
                    Text("Content for \(currentScreen.title)")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


struct BottomNavigationView: View {
    @State private var selectedScreen: BottomNavigationScreen = .Home

    var body: some View {
        TabView(selection: $selectedScreen) {
            ForEach(BottomNavigationScreen.allCases, id: \.self) { screen in
                screen.view
                    .tabItem {
                        Image(systemName: screen.iconName)
                            .renderingMode(.template)
                        Text(screen.title)
                    }
                    .tag(screen)
            }
        }
        .accentColor(.black)
        .background(Color.white)
        .onAppear {
            UITabBar.appearance().backgroundColor = UIColor.white
            UITabBar.appearance().unselectedItemTintColor = UIColor.gray
        }
    }
}

enum BottomNavigationScreen: String, CaseIterable, Identifiable {
    case Home
    case Progress
    case Inspiration
    case Inbox
    case Info

    var id: String { self.rawValue }

    var iconName: String {
        switch self {
        case .Home: return "house"
        case .Progress: return "chart.bar"
        case .Inspiration: return "lightbulb"
        case .Inbox: return "envelope"
        case .Info: return "info.circle"
        }
    }

    var title: String {
        switch self {
        case .Home: return "Home"
        case .Progress: return "Progress"
        case .Inspiration: return "Inspo"
        case .Inbox: return "Inbox"
        case .Info: return "Info"
        }
    }

    var view: some View {
        switch self {
        case .Home: return AnyView(Text("Home View"))
        case .Progress: return AnyView(Text("Progress View"))
        case .Inspiration: return AnyView(Text("Inspiration View"))
        case .Inbox: return AnyView(Text("Inbox View"))
        case .Info: return AnyView(Text("Info View"))
        }
    }
}


enum Screen: Hashable {
    case main
    case meal
    
    var route: String {
        switch self {
        case .main: return "main"
        case .meal: return "meal"
        }
    }
    
    var title: String {
        switch self {
        case .main: return "Main"
        case .meal: return "Meal"
        }
    }
}

struct MainScreen: View {
    @State private var selectedScreen: BottomNavigationScreen = .Home
    
    var body: some View {
        VStack(spacing: 0) {
            TopAppBar(title: selectedScreen.title)
            
            ZStack {
                switch selectedScreen {
                    case .Home:
                        HomeScreen()
                    default:
                        Text("Content for \(selectedScreen.title)")
                }
            }
            
            BottomNavigationBar()
        }
    }
}

struct TopAppBar: View {
    let title: String
    
    var body: some View {
        HStack {
            Button(action: {}) {
                Image(systemName: "bell")
                    .foregroundColor(.white)
            }
            
            Spacer()
            
            Text(title)
                .foregroundColor(.white)
                .fontWeight(.bold)
            
            Spacer()
            
            Button(action: {}) {
                Image(systemName: "gear")
                    .foregroundColor(.white)
            }
        }
        .padding()
        .background(Color(red: 99/255, green: 0/255, blue: 78/255))
    }
}

struct BottomNavigationBar: View {
    @State private var selectedTab: Tab = .home

     enum Tab {
         case home, progress, inspo, inbox, info
     }

     var body: some View {
         TabView(selection: $selectedTab) {
             HomeScreen()
                 .tabItem {
                     Label("Home", systemImage: "house")
                 }
                 .tag(Tab.home)
             ProgressView()
                 .tabItem {
                     Label("Progress", systemImage: "chart.bar")
                 }
                 .tag(Tab.progress)
             
             ProgressView()
                 .tabItem {
                     Label("Inspo", systemImage: "lightbulb")
                 }
                 .tag(Tab.inspo)
             
             ProgressView()
                 .tabItem {
                     Label("Inbox", systemImage: "envelope")
                 }
                 .tag(Tab.inbox)
             
             ProgressView()
                 .tabItem {
                     Label("Info", systemImage: "info.circle")
                 }
                 .tag(Tab.info)
         }
     }
}

struct UserGreeting: View {
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

struct DailyCheckInCard: View {
    var body: some View {
        Text("Daily Check-In Card Placeholder")
            .padding()
            .background(Color.white)
            .cornerRadius(10)
    }
}

struct TasksSection: View {
    var body: some View {
        Text("Tasks Section Placeholder")
            .padding()
            .background(Color.white)
            .cornerRadius(10)
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

struct CircularProgressView: View {
    let progress: Double
    let totalTasks: Int
    let completedTasks: Int
    
    var body: some View {
        VStack {
            ZStack {
                Circle()
                    .stroke(Color.gray.opacity(0.2), lineWidth: 4)
                Circle()
                    .trim(from: 0, to: progress)
                    .stroke(Color.yellow, lineWidth: 4)
                    .rotationEffect(.degrees(-90))
                
                Text("\(Int(progress * 100))%")
                    .font(.caption)
            }
            .frame(width: 50, height: 50)
            
            Text("\(completedTasks)/\(totalTasks)")
                .font(.caption)
                .padding(4)
                .background(Color.black.opacity(0.1))
                .cornerRadius(6)
        }
    }
}
