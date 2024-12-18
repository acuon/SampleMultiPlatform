import SwiftUI
import Shared

struct ContentView: View {
    @ObservedObject var viewModel: SampleViewModel = SampleViewModel()
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
             
             Text("Content for Inspo")
                 .tabItem {
                     Label("Inspo", systemImage: "lightbulb")
                 }
                 .tag(Tab.inspo)
             
             Text("Content for Inbox")
                 .tabItem {
                     Label("Inbox", systemImage: "envelope")
                 }
                 .tag(Tab.inbox)
             
             Text("Content for Info")
                 .tabItem {
                     Label("Info", systemImage: "info.circle")
                 }
                 .tag(Tab.info)
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
