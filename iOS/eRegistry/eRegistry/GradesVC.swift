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
//    @IBOutlet weak var bottomView: UIView! {
//        didSet {
//            bottomView.backgroundColor = Colors.MAIN
//        }
//    }
//    @IBOutlet weak var userInfoLabel: UILabel! {
//        didSet {
//            userInfoLabel.textColor = UIColor.white
//            userInfoLabel.text = "Zalogowano jako: \(UserDefaultValues.username)"
//        }
//    }
//    @IBOutlet weak var userTypeLabel: UILabel! {
//        didSet {
//            userTypeLabel.textColor = UIColor.white
//            userTypeLabel.text = "Uczeń"
//        }
//    }
    
    let CELL_ID = "GradeCVCell"
    
    var subjects: [Subject] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.title = "Oceny"

        downloadData()
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    private func downloadData() {
        
        let grades1 = [
            Grade(mark: 3, date: "11.09.2016", description: "Sprawdzian I"),
            Grade(mark: 4, date: "23.09.2016", description: "Kartkówka I"),
            Grade(mark: 3, date: "15.10.2016", description: "Kartkówka II"),
            Grade(mark: 2, date: "19.11.2016", description: "Sprawdzian II"),
            Grade(mark: 2, date: "05.12.2016", description: "Odpowiedź")
        ]
        let grades2 = [
            Grade(mark: 3, date: "11.09.2016", description: "Sprawdzian I"),
            Grade(mark: 3, date: "23.09.2016", description: "Kartkówka I"),
            Grade(mark: 4, date: "15.10.2016", description: "Kartkówka II"),
            Grade(mark: 5, date: "19.11.2016", description: "Sprawdzian II"),
            Grade(mark: 5, date: "05.12.2016", description: "Odpowiedź"),
            Grade(mark: 3, date: "04.01.2017", description: "Sprawdzian III"),
            Grade(mark: 2, date: "05.02.2017", description: "Odpowiedź")
        ]
        let grades3 = [
            Grade(mark: 5, date: "11.09.2016", description: "Sprawdzian I"),
            Grade(mark: 4, date: "23.09.2016", description: "Kartkówka I"),
            Grade(mark: 5, date: "15.10.2016", description: "Kartkówka II"),
            Grade(mark: 4, date: "19.11.2016", description: "Sprawdzian II"),
            Grade(mark: 5, date: "05.12.2016", description: "Odpowiedź")
        ]
        let grades4 = [
            Grade(mark: 5, date: "11.09.2016", description: "Sprawdzian I"),
            Grade(mark: 5, date: "23.09.2016", description: "Kartkówka I"),
            Grade(mark: 5, date: "15.10.2016", description: "Kartkówka II"),
            Grade(mark: 5, date: "19.11.2016", description: "Sprawdzian II"),
            Grade(mark: 3, date: "05.12.2016", description: "Odpowiedź"),
            Grade(mark: 4, date: "01.02.2017", description: "Odpowiedź")
        ]
        let grades5 = [
            Grade(mark: 5, date: "11.09.2016", description: "Sprawdzian I"),
            Grade(mark: 5, date: "23.09.2016", description: "Kartkówka I"),
            Grade(mark: 5, date: "15.10.2016", description: "Kartkówka II"),
            Grade(mark: 4, date: "05.12.2016", description: "Odpowiedź")
        ]
        let grades6 = [
            Grade(mark: 1, date: "17.09.2016", description: "Sprawdzian I"),
            Grade(mark: 1, date: "20.09.2016", description: "Kartkówka I"),
            Grade(mark: 2, date: "01.10.2016", description: "Kartkówka II"),
            Grade(mark: 2, date: "22.11.2016", description: "Sprawdzian II"),
            Grade(mark: 2, date: "20.12.2016", description: "Odpowiedź")
        ]
        let grades7 = [
            Grade(mark: 2, date: "05.10.2016", description: "Odpowiedź"),
            Grade(mark: 2, date: "25.10.2016", description: "Odpowiedź"),
            Grade(mark: 2, date: "19.11.2016", description: "Kartkówka"),
            Grade(mark: 2, date: "19.01.2017", description: "Odpowiedź")
        ]
        let grades8 = [
            Grade(mark: 3, date: "05.10.2016", description: "Odpowiedź"),
            Grade(mark: 3, date: "25.10.2016", description: "Odpowiedź"),
            Grade(mark: 4, date: "19.11.2016", description: "Kartkówka"),
            Grade(mark: 3, date: "13.12.2016", description: "Odpowiedź"),
            Grade(mark: 4, date: "11.01.2017", description: "Odpowiedź")
        ]
        
        subjects.append(Subject(name: "Matematyka", grades: grades1))
        subjects.append(Subject(name: "J. polski", grades: grades2))
        subjects.append(Subject(name: "J. angielski", grades: grades8))
        subjects.append(Subject(name: "J. francuski", grades: grades4))
        subjects.append(Subject(name: "J. niemiecki", grades: grades5))
        subjects.append(Subject(name: "Fizyka", grades: grades6))
        subjects.append(Subject(name: "Chemia", grades: grades3))
        subjects.append(Subject(name: "Biologia", grades: grades4))
        subjects.append(Subject(name: "Historia", grades: grades1))
        subjects.append(Subject(name: "Muzyka", grades: grades7))
        subjects.append(Subject(name: "Informatyka", grades: grades8))
        subjects.append(Subject(name: "Religia", grades: grades7))
        subjects.append(Subject(name: "WF", grades: grades2))
        
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
    
    func collectionView(_ collectionView: UICollectionView, didHighlightItemAt indexPath: IndexPath) {
        guard let cell = collectionView.cellForItem(at: indexPath) as? GradeCVCell else { return }
        cell.removeShadow()
    }
    
    func collectionView(_ collectionView: UICollectionView, didUnhighlightItemAt indexPath: IndexPath) {
        guard let cell = collectionView.cellForItem(at: indexPath) as? GradeCVCell else { return }
        cell.addShadow()
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        guard let cell = collectionView.cellForItem(at: indexPath) as? GradeCVCell else { return }
        goToDetailedSubjectView(for: cell.subject)
    }
    
    private func goToDetailedSubjectView(for subject: Subject?) {
        guard let subjectVC = UINib(nibName: "SubjectDetailsVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? SubjectDetailsVC else {
            return
        }
        subjectVC.setSubject(subject)
        navigationController?.pushViewController(subjectVC, animated: true)
    }
    
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
