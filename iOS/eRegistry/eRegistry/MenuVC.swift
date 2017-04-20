//
//  MenuVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 11.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class MenuVC: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView! {
        didSet {
            let menuCellNib = UINib(nibName: CELL_ID, bundle: nil)
            collectionView.register(menuCellNib, forCellWithReuseIdentifier: CELL_ID)
            collectionView.delegate = self
            collectionView.dataSource = self
            collectionView.backgroundColor = Colors.MAIN
        }
    }
    
    let CELL_ID = "MenuCVCell"
    
    var menuItems: [MenuItemModel] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    func prepare(for type: UserRole) {
        switch type {
        case .student:
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "gradeMenuIcon"), description: "Oceny", type: .grades))
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "teacherMenuIcon"), description: "Wychowawca", type: .teacher))
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "infoMenuIcon"), description: "Informacje", type: .settings))
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "powerMenuIcon"), description: "Wyloguj", type: .logout))
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "powerMenuIcon"), description: "Wyloguj", type: .logout))
            print("Student")
        case .teacher:
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "gradeMenuIcon"), description: "Podopieczni", type: .children))
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "infoMenuIcon"), description: "Informacje", type: .settings))
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "powerMenuIcon"), description: "Wyloguj", type: .logout))
            menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "powerMenuIcon"), description: "Wyloguj", type: .logout))
            print("Teacher")
        default:
            print("Default")
        }
    }
    
    override func viewWillAppear(_ animated: Bool) {
        prepareNavigationBar()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    private func prepareNavigationBar() {
        self.title = "Menu"
        
        self.navigationItem.hidesBackButton = true
    }

    func initMenuItems() {
        
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "gradeMenuIcon"), description: "Oceny", type: .grades))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "teacherMenuIcon"), description: "Wychowawca", type: .teacher))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "infoMenuIcon"), description: "Informacje", type: .settings))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "powerMenuIcon"), description: "Wyloguj", type: .logout))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "powerMenuIcon"), description: "Wyloguj", type: .logout))
//        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Telefon", type: .phone))
//        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Adres", type: .address))
//        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Email", type: .email))
        
    }
    
}

// MARK: - UICollectionView protocols

extension MenuVC : UICollectionViewDelegate, UICollectionViewDataSource {
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell: MenuCVCell = collectionView.dequeueReusableCell(withReuseIdentifier: CELL_ID, for: indexPath) as? MenuCVCell else {
            return UICollectionViewCell()
        }
        cell.setModel(menuItems[indexPath.item])
        return cell
    }
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 1
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return menuItems.count
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        let menuItem = menuItems[indexPath.item]
        switch menuItem.type {
        case .grades:
            print("Oceny")
            goToGrades()
        case .teacher:
            print("Wychowawca")
            goToEducator()
        case .settings:
            print("Ustawienia")
            goToSettings()
        case .children:
            print("Podopieczni")
            goToChildren()
        case .logout:
            print("Wyloguj")
            logout()
        }
        RequestManager.getUsers()
    }
    
    private func goToGrades() {
        guard let gradeVC = UINib(nibName: "GradesVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? GradesVC else {
            return
        }
        navigationController?.pushViewController(gradeVC, animated: true)
    }
    
    private func goToEducator() {
        guard let educatorVC = UINib(nibName: "EducatorVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? EducatorVC else {
            return
        }
        let educator = Educator(name: "Anna", surname: "Nowakowska", phone: "513 783 994", email: "nowakowska.anna@gmail.com")
        educatorVC.setView(for: educator)
        navigationController?.pushViewController(educatorVC, animated: true)
    }
    
    private func goToSettings() {
        guard let settingsVC = UINib(nibName: "SettingsVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? SettingsVC else {
            return
        }
        self.navigationController?.pushViewController(settingsVC, animated: true)
    }
    
    private func goToChildren() {
//        guard let childrenVC = UINib(nibName: "ChildrenVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? ChildrenVC else {
//            return
//        }
//        self.navigationController?.pushViewController(childrenVC, animated: true)
    }
    
    private func logout() {
        User.instance.rememberMe = false
        let _ = self.navigationController?.popToRootViewController(animated: true)
    }
    
}

extension MenuVC : UICollectionViewDelegateFlowLayout {
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let bound = calculateCellSideLength()
        let size = CGSize(width: bound, height: bound)
        return size
    }
    
    private func calculateCellSideLength() -> CGFloat {
        var width: CGFloat = 0.0
        var height: CGFloat = 0.0
        if UIDevice.current.orientation.isLandscape {
            height = collectionView.bounds.height/2
            width = collectionView.bounds.width/3
        } else {
            height = collectionView.bounds.height/3
            width = collectionView.bounds.width/2
        }
        let bound = width < height ? width : height
        return bound
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
    
}
