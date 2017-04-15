//
//  GradesVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 14.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class GradesVC: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView! {
        didSet {
            let cellNib = UINib(nibName: CELL_ID, bundle: nil)
            collectionView.register(cellNib, forCellWithReuseIdentifier: CELL_ID)
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
    
    let CELL_ID = "GradeCVCell"
    
    var subjects: [Subject] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.title = "Oceny"
        
        subjects.append(Subject(name: "Matematyka", averageGrade: 3.23))
        subjects.append(Subject(name: "J. polski", averageGrade: 4.33))
        subjects.append(Subject(name: "J. angielski", averageGrade: 4.4))
        subjects.append(Subject(name: "J. francuski", averageGrade: 3.0))
        subjects.append(Subject(name: "J. niemiecki", averageGrade: 2.39))
        subjects.append(Subject(name: "Fizyka", averageGrade: 3.5))
        subjects.append(Subject(name: "Chemia", averageGrade: 3.33))
        subjects.append(Subject(name: "Biologia", averageGrade: 4.13))
        subjects.append(Subject(name: "Historia", averageGrade: 4.89))
        subjects.append(Subject(name: "Muzyka", averageGrade: 4.66))
        subjects.append(Subject(name: "Informatyka", averageGrade: 2.0))
        subjects.append(Subject(name: "Religia", averageGrade: 1.0))
        subjects.append(Subject(name: "WF", averageGrade: 5.0))
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

extension GradesVC : UICollectionViewDelegate, UICollectionViewDataSource {
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell: GradeCVCell = collectionView.dequeueReusableCell(withReuseIdentifier: CELL_ID, for: indexPath) as? GradeCVCell else {
            return UICollectionViewCell()
        }
        cell.setSubject(subjects[indexPath.row])
        return cell
    }
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 1
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return subjects.count
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        return
    }
//    
//    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
//        return UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
//    }
    
}

extension GradesVC : UICollectionViewDelegateFlowLayout {
    
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
