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
        }
    }
    @IBOutlet weak var bottomView: UIView! {
        didSet {
            bottomView.backgroundColor = Colors.MAIN
        }
    }
    @IBOutlet weak var userInfoLabel: UILabel! {
        didSet {
            userInfoLabel.textColor = UIColor.white
            userInfoLabel.text = "Zalogowano jako: \(UserDefaultValues.username)"
        }
    }
    @IBOutlet weak var userTypeLabel: UILabel! {
        didSet {
            userTypeLabel.textColor = UIColor.white
            userTypeLabel.text = "Uczeń"
        }
    }
    
    let CELL_ID = "MenuCVCell"
    
    var menuItems: [MenuItemModel] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        initMenuItems()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        prepareNavigationBar()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func prepareNavigationBar() {
        self.title = "Menu"
        
        self.navigationItem.hidesBackButton = true
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(title: "Wyloguj", style: .plain, target: self, action: #selector(logout))
        self.navigationItem.leftBarButtonItem = UIBarButtonItem(image: #imageLiteral(resourceName: "settingsIcon"), style: .plain, target: self, action: #selector(goToSettings))
    }

    func initMenuItems() {
        
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Oceny", type: .grades))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Wychowawca", type: .teacher))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Telefon", type: .phone))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Adres", type: .address))
        menuItems.append(MenuItemModel(image: #imageLiteral(resourceName: "logoIcon"), description: "Email", type: .email))
        
    }
    
    func logout() {
        UserDefaultValues.rememberMe = false
        let _ = self.navigationController?.popToRootViewController(animated: true)
    }
    
    func goToSettings() {
        guard let settingsVC = UINib(nibName: "SettingsVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? SettingsVC else {
            return
        }
        self.navigationController?.pushViewController(settingsVC, animated: true)
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
            guard let gradeVC = UINib(nibName: "GradesVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? GradesVC else {
                return
            }
            navigationController?.pushViewController(gradeVC, animated: true)
        case .teacher:
            print("Wychowawca")
        case .phone:
            print("Telefon")
        case .address:
            print("Adres")
        case .email:
            print("Email")
        }
        RequestManager.getUsers()
    }
    
//    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
//        return UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
//    }
    
}

extension MenuVC : UICollectionViewDelegateFlowLayout {
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let height = collectionView.bounds.height/3
        let width = collectionView.bounds.width/2
        let bound = width < height ? width : height
        let size = CGSize(width: bound, height: bound)
        return size
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
    
}
